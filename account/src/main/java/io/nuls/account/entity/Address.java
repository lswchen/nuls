package io.nuls.account.entity;

import io.nuls.core.utils.crypto.Base58;

/**
 * Created by Niels on 2017/10/30.
 * nuls.io
 */
public class Address{
    //base58 length
    public static final int HASH_LENGTH = 25;
    // RIPEMD160 length
    public static final int LENGTH = 20;
    //content
    protected byte[] hash160;

    public Address(byte[] hash160) {
        this.hash160 = hash160;
    }

    public byte[] getHash160() {
        return hash160;
    }

    public String toString(){
        return Base58.encode(hash160);
    }
}