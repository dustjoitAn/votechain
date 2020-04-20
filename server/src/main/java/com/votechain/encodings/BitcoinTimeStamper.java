package com.votechain.encodings;

import org.bitcoinj.core.Coin;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.kits.WalletAppKit;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.params.TestNet3Params;
import org.bitcoinj.script.ScriptBuilder;
import org.bitcoinj.wallet.DeterministicSeed;
import org.bitcoinj.wallet.UnreadableWalletException;
import org.bitcoinj.wallet.Wallet;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class BitcoinTimeStamper {

    private static final File POSIX_TEMP_DIRECTORY = new File("/tmp");
    private static final int SHA256_LENGTH = 32;
    private static final int MAX_PREFIX_LENGTH = 8;
    private static final byte NULL_BYTE = (byte) '\0';
    // This is simply to get a sha256 implementation
    private static MessageDigest SHA_256 = null;
    ;

    static {
        try {
            SHA_256 = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException nsae) {
            throw new RuntimeException("Programmer error.", nsae);
        }
    }

    private WalletAppKit walletAppKit;

    public BitcoinTimeStamper(BitcoinNet bitcoinNet, String seedWords, long seedCreationTime, File tempDirectory) {

        // Configure network parameters for the appropriate net
        NetworkParameters params;
        if (bitcoinNet.equals(BitcoinNet.TEST)) {
            params = TestNet3Params.get();
        } else if (bitcoinNet.equals(BitcoinNet.MAIN)) {
            params = MainNetParams.get();
        } else {
            throw new RuntimeException("Programmer error.");
        }

        // Generate a wallet from the given seed values
        DeterministicSeed seed = null;
        try {
            seed = new DeterministicSeed(seedWords, null, "", seedCreationTime);
        } catch (UnreadableWalletException uwe) {
            throw new RuntimeException(uwe);
        }
        walletAppKit = new WalletAppKit(params, tempDirectory, ".spv");
        walletAppKit.restoreWalletFromSeed(seed);

    }

    public BitcoinTimeStamper(BitcoinNet bitcoinNet, String seedWords, long seedCreationTime) {
        this(bitcoinNet, seedWords, seedCreationTime, POSIX_TEMP_DIRECTORY);
    }

    public void initialise() {
        walletAppKit.setAutoSave(true);
        walletAppKit.setBlockingStartup(true);

        walletAppKit.startAsync();
    }

    public void stop() {
        walletAppKit.stopAsync();
    }

    public boolean isReady() {
        return walletAppKit.isRunning();
    }

    public void waitUntilReady() {
        walletAppKit.awaitRunning();
    }

    public String attest(String prefix, byte[] subject) throws EmptyBitcoinAccountException {

        final Wallet wallet = walletAppKit.wallet();

        // Take the actual sha256 to embed
        byte[] hash = SHA_256.digest(subject);

        // ASCII encode the prefix
        byte[] prefixBytes = prefix.getBytes(StandardCharsets.US_ASCII);
        if (MAX_PREFIX_LENGTH < prefix.length()) {
            throw new IllegalArgumentException("OP_RETURN prefix is too long: " + prefix);
        }

        // Construct the OP_RETURN data
        byte[] opReturnValue = new byte[40];
        Arrays.fill(opReturnValue, NULL_BYTE);
        System.arraycopy(prefixBytes, 0, opReturnValue, 0, prefixBytes.length);
        System.arraycopy(hash, 0, opReturnValue, MAX_PREFIX_LENGTH, SHA256_LENGTH);

        // Construct a OP_RETURN transaction
        Transaction transaction = new Transaction(wallet.getParams());
        transaction.addOutput(
                Coin.ZERO,
                ScriptBuilder.createOpReturnScript(hash)
        );

        /*Wallet.SendRequest sendRequest = Wallet.SendRequest.forTx(transaction);

        // Fill-in the missing details for our wallet, eg. fees.
        try {
            wallet.completeTx(sendRequest);
        } catch (InsufficientMoneyException e) {
            throw new EmptyBitcoinAccountException();
        }

        // Broadcast and commit transaction
        walletAppKit.peerGroup().broadcastTransaction(transaction);
        wallet.commitTx(transaction);
*/
        // Return a reference to the caller
        return transaction.getHashAsString();
    }

    @Override
    public void finalize() throws Throwable {
        this.stop();
        super.finalize();
    }

    public enum BitcoinNet {MAIN, TEST}

    public class EmptyBitcoinAccountException extends Exception {
    }
}
