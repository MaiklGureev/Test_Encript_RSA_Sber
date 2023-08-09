package com.example.testencript

import android.os.Bundle
import android.util.Base64
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.security.GeneralSecurityException
import java.security.Key
import java.security.KeyFactory
import java.security.PrivateKey
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec
import java.util.*
import javax.crypto.Cipher


val pubkey =
    "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiDgvGLU1dFQ0tA0Epbpj1gbbAz9/lvZdTyspHCPQ4zTYki1xER8Dy99jzxj83VIiamnwkHUsmcg5mxXfRI/Y7mDq9LT1mmoM5RytpfuuFELWrBE59jZzc4FgwcVdvR8oV4ol7RDPDHpSxl9ihC1h2KZ/GoKi9G6TULRzD+hLeo9vIpC0vIIGUyxDWtOWi0yDf4MYisUKmgbYya+Z5oODANHUCiJuMMuuH7ot6hJPxZ61LE0FQP6pxo+r1cezGekwlc8NrKq3XeeNgu4kWFXNTBSwAcNAizIvEY4wrqc4ARR3nTlwAxkye9bTNVNROMMiMtu1ERGyRFjI7wnSmRnNEwIDAQAB"
val privkey =
    "MIIEowIBAAKCAQEAiDgvGLU1dFQ0tA0Epbpj1gbbAz9/lvZdTyspHCPQ4zTYki1xER8Dy99jzxj83VIiamnwkHUsmcg5mxXfRI/Y7mDq9LT1mmoM5RytpfuuFELWrBE59jZzc4FgwcVdvR8oV4ol7RDPDHpSxl9ihC1h2KZ/GoKi9G6TULRzD+hLeo9vIpC0vIIGUyxDWtOWi0yDf4MYisUKmgbYya+Z5oODANHUCiJuMMuuH7ot6hJPxZ61LE0FQP6pxo+r1cezGekwlc8NrKq3XeeNgu4kWFXNTBSwAcNAizIvEY4wrqc4ARR3nTlwAxkye9bTNVNROMMiMtu1ERGyRFjI7wnSmRnNEwIDAQABAoIBAF09+B71iw2BxkGo15GJsGUEdE4Y3QE8ykoyxQUaDxY3SjdlG4wYqsSWuP89n3jvi9dDhQOc8Vaik6vwoM+Rl3A0rx+p7qQwC3uY0dRYHqSHy+IkOISsaQKbgNuiebPG7Bpf2e4YH2HvKVHYYNsRJXTjIwXGfjzKo9QOcORmoaPWHuCie1o41Sn6JTzC/mMsLRf+Ih2Rr5JuJxIR2pCIbX0gqlI7ZkqjICVPsnyCXU8aGspaWo6PlIwYfn/r2bIBo3Uk5PkngwRwqZQy5OWzX5gZ4CT+EDsuMx/cKbahn/iUyVyxYwgGg04WqTBKjKdUsonkhh680hV+NkZk7H0IoWECgYEA3+g3tBTk1OxwVPDwRSvphPl56LYESGkESJAkbU+IFYezNnUGzEYtoS5gZfm49IStFTF/45EzOgBboNzeatj5egpR+WbdIugsXfpuJ4+yJ7b1J4bjVHm84ctCWXk+KZSJk7xQr2I41xrpjPuYVIxd9jCR7zABcM39eFBR7yzcCe0CgYEAm751yXTBYGhzNdgdvGTfjqwjSdUNA//yJHtqdcftlUvu+solpn40tn79kBTAqL3U1G67HcFb42SFv0brSCEBfJKEZPnJrPP8njEGnL+8Pxgd0dndxPtk1KuJQgs7C8N2OJRbI1KMs43iTIJAfoXm4nhC4Re3Yx5KQ8m6Z9n2Uv8CgYB3TBzRwAgkQk2flDgQQtNK3DlN+hzSD9IOb25ZJ3TUM9cSfsu+bu3E4RbPfnxDG6W0kwkW0LhAgQxQ6x0+RJi3o2QFw/6yqI1rDRE/1toPOvXnt4DL84jlrQyO64BpWxDqO/2pVGYAhgBF8484DQnLMBmxHRzHY5lXT0Q4cOhUCQKBgEOWhxVTNux4x67RSC5O9Hm9GF9dNxXKSDIu4QeWKPPGjUKG4Yn8cTHVsIKLjwRrxWYfW9LQ6+il4ikdRNP7huKhzxTnFe+ZvsKD8iOqTa5v79j3HHf0xVBJ1Po1V32GaNKrB1Yv5+GwLEoZqJV/1K/pktSOb0ZzibUbYWraOzzPAoGBALUpcJI+wQ1V4Xkutg7JWPiT7a8f31iGOIcH39PE/Y7wt2/WBD/EgLEKtD8AcghBnpk4qMg0IHAr91QG328BFYrLLYB+UgeZjPXIAHdCuonCh/xFqFJkLSjTapPMUOIf9vNvKf/odiQ7gMm5wrESuOpq0BWlBIe5saXW5J7cnV9D"
val mesage =
    "2023-07-15T11:23+00:00/3a1b41e7-e0a2-416e-add3-671f04079051/5555555555555599///0e47a147-1d18-745f-8747-ae5228f962ee"


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val encryptedMessage = encryptRSAToString(mesage, pubkey)
        val decryptedMessage = decryptRSAToString(encryptedMessage, privkey)

        findViewById<TextView>(R.id.text).apply {
            val string = StringBuilder()
                .appendLine("encryptedMessage:")
                .appendLine(encryptedMessage)
                .appendLine("\n")
                .appendLine("decryptedMessage:")
                .appendLine(decryptedMessage)
            text = string
        }
    }

    private fun decryptRSAToString(encryptedMessage: String, privkey: String): String {
        return decryptMessage(encryptedMessage, privkey)
    }

    private fun encryptRSAToString(mesage: String, pubkey: String): String {
        return encryptMessage(mesage, pubkey)
    }

    // Encrypt using publickey
    @Throws(Exception::class)
    fun encryptMessage(plainText: String, publickey: String): String {
        val cipher = Cipher.getInstance("RSA/None/PKCS1Padding")
        cipher.init(Cipher.ENCRYPT_MODE, loadPublicKey(publickey))
        return String(Base64.encode(cipher.doFinal(plainText.toByteArray()), Base64.NO_WRAP))

    }

    // Decrypt using privatekey
    @Throws(Exception::class)
    fun decryptMessage(encryptedText: String?, privatekey: String):
            String {
        val cipher = Cipher.getInstance("RSA/None/PKCS1Padding")
        cipher.init(Cipher.DECRYPT_MODE, loadPrivateKey(privatekey))
        return String(cipher.doFinal(Base64.decode(encryptedText, Base64.NO_WRAP)))
    }

    // Convert String private key to privateKey object
    @Throws(GeneralSecurityException::class)
    fun loadPrivateKey(key64: String): PrivateKey {
        val clear: ByteArray = Base64.decode(key64.toByteArray(), Base64.NO_WRAP)
        val keySpec = PKCS8EncodedKeySpec(clear)
        val fact = KeyFactory.getInstance("RSA")
        val priv = fact.generatePrivate(keySpec)
        Arrays.fill(clear, 0.toByte())
        return priv
    }

    // convert String publickey to Key object
    @Throws(GeneralSecurityException::class, IOException::class)
    fun loadPublicKey(stored: String): Key {
        val data: ByteArray = Base64.decode(stored.toByteArray(), Base64.NO_WRAP)
        val spec = X509EncodedKeySpec(data)
        val fact = KeyFactory.getInstance("RSA")
        return fact.generatePublic(spec)
    }
}
