package almudena.miprimeraapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_anadir_contacto.*
import kotlinx.android.synthetic.main.activity_mandar_email.*

class MandarCorreoActivity : AppCompatActivity() {
    private var receptor: String = ""
    private var asunto: String = ""
    private var mensaje: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mandar_email)

        btn_mandarCorreo_enviar.setOnClickListener{
            this.receptor = txte_mandarCorreo_Receptor.text.toString()
            this.asunto = txt_mandarCorreo_asunto.text.toString()
            this.mensaje = txtm_mandarCorreo_mensaje.text.toString()

            mandarCorreo(receptor, asunto, mensaje)
        }
    }

    private fun mandarCorreo(receptor: String, asunto: String, mensaje: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:")
        intent.type = "text/plain"
        // Los receptores deben ser un array, ya sean uno o varios, por eso los casteamos
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(receptor))
        intent.putExtra(Intent.EXTRA_SUBJECT, asunto)
        intent.putExtra(Intent.EXTRA_TEXT, mensaje)
        try {
            startActivity(Intent.createChooser(intent, "Enviar usando..."))
        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }
}