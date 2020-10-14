package almudena.miprimeraapp

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.*
import android.provider.ContactsContract.Intents.Insert.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_anadir_contacto.*

class AnadirContactoActivity : AppCompatActivity() {
    private var nombre: String = ""
    private var correo: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_contacto)

        btn_anadirAmigo_Aceptar.setOnClickListener{
            this.nombre = txt_anadirAmigo_nombre.text.toString()
            this.correo = txtEmail_anadirAmigo_email.text.toString()

            insertContact(nombre, correo)
        }
    }

    fun insertContact(name: String, email: String) {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            type = Contacts.CONTENT_TYPE
            putExtra(NAME, name)
            putExtra(EMAIL, email)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}