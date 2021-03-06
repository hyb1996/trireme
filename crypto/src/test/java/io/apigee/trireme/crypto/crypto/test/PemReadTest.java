package io.apigee.trireme.crypto.crypto.test;

import io.apigee.trireme.crypto.CryptoServiceImpl;
import io.apigee.trireme.kernel.crypto.CryptoException;
import io.apigee.trireme.kernel.crypto.CryptoService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.cert.X509Certificate;

import static org.junit.Assert.*;

public class PemReadTest
{
    private static CryptoService service;
    private static final char[] PASSPHRASE = "secret".toCharArray();

    @BeforeClass
    public static void init()
    {
        service = new CryptoServiceImpl();
    }

    @Test
    public void testRsaKeyPair()
        throws IOException, CryptoException
    {
        InputStream is = PemReadTest.class.getResourceAsStream("/rsakeypair.pem");
        KeyPair kp = service.readKeyPair("RSA", is, null);
        assertNotNull(kp);
    }

    @Test
    public void testRsaKeyPairDes()
        throws IOException, CryptoException
    {
        InputStream is = PemReadTest.class.getResourceAsStream("/rsakeypairdes.pem");
        KeyPair kp = service.readKeyPair("RSA", is, PASSPHRASE);
        assertNotNull(kp);
    }

    @Test
    public void testRsaKeyPairDes3()
        throws IOException, CryptoException
    {
        InputStream is = PemReadTest.class.getResourceAsStream("/rsakeypairdes3.pem");
        KeyPair kp = service.readKeyPair("RSA", is, PASSPHRASE);
        assertNotNull(kp);
    }

    @Test
    public void testRsaKeyPairAes()
        throws IOException, CryptoException
    {
        InputStream is = PemReadTest.class.getResourceAsStream("/rsakeypairaes.pem");
        KeyPair kp = service.readKeyPair("RSA", is, PASSPHRASE);
        assertNotNull(kp);
    }

    @Test
    public void testDsaKeyPair()
        throws IOException, CryptoException
    {
        InputStream is = PemReadTest.class.getResourceAsStream("/dsakeypair.pem");
        KeyPair kp = service.readKeyPair("DSA", is, null);
        assertNotNull(kp);
    }
    /*
    @Test
    public void testDsaKeyPairDes3()
        throws IOException, CryptoException
    {
        InputStream is = PemReadTest.class.getResourceAsStream("/dsakeypairdes3.pem");
        KeyPair kp = service.readKeyPair("DSA", is, PASSPHRASE);
        assertNotNull(kp);
    }
    */

    @Test
    public void testRsaPublicKey()
        throws IOException, CryptoException
    {
        InputStream is = PemReadTest.class.getResourceAsStream("/rsapublickey.pem");
        PublicKey pk = service.readPublicKey("RSA", is);
        assertNotNull(pk);
    }

    @Test
    public void testRsaPublicKey2()
        throws IOException, CryptoException
    {
        InputStream is = PemReadTest.class.getResourceAsStream("/test_rsa_pubkey.pem");
        PublicKey pk = service.readPublicKey("RSA", is);
        assertNotNull(pk);
    }

    @Test
    public void testRsaPublicKey3()
        throws IOException, CryptoException
    {
        InputStream is = PemReadTest.class.getResourceAsStream("/test_rsa_pubkey_2.pem");
        PublicKey pk = service.readPublicKey("RSA", is);
        assertNotNull(pk);
    }

    @Test
    public void testDsaPublicKey()
        throws IOException, CryptoException
    {
        InputStream is = PemReadTest.class.getResourceAsStream("/dsapublickey.pem");
        PublicKey pk = service.readPublicKey("DSA", is);
        assertNotNull(pk);
    }

    @Test
    public void testRsaCert()
        throws IOException, CryptoException
    {
        InputStream is = PemReadTest.class.getResourceAsStream("/rsacert.pem");
        X509Certificate cert = service.readCertificate(is);
        assertNotNull(cert);
    }

    @Test
    public void testPkcs8PrivateKey()
        throws IOException, CryptoException
    {
        InputStream is = PemReadTest.class.getResourceAsStream("/pkcs8key.pem");
        KeyPair kp = service.readKeyPair("RSA", is, null);
        assertNotNull(kp);
    }

    @Test
    public void testPkcs8EncryptedPrivateKey()
        throws IOException, CryptoException
    {
        InputStream is = PemReadTest.class.getResourceAsStream("/pkcs8encryptedkey.pem");
        KeyPair kp = service.readKeyPair("RSA", is, PASSPHRASE);
        assertNotNull(kp);
    }
}
