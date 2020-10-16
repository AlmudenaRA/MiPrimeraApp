package almudena.miprimeraapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.actions.NoteIntents
import kotlinx.android.synthetic.main.activity_anadir_nota.*
import kotlinx.android.synthetic.main.activity_mandar_email.*

//import com.google.android.gms.actions.CREATE_NOTE

class AnadirNotaActivity: AppCompatActivity() {
    private var nombre: String = ""
    private var texto: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_nota)

        btn_anadirNota_anadir.setOnClickListener{
            this.nombre = txt_anadirNota_nombre.text.toString()
            this.texto = etxtm_anadirNota_texto.text.toString()

            crearNota(nombre, texto)
        }
    }

    fun crearNota(subject: String, text: String) {
        val intent = Intent(NoteIntents.ACTION_CREATE_NOTE).apply {
            putExtra(NoteIntents.EXTRA_NAME, nombre)
            putExtra(NoteIntents.EXTRA_TEXT, texto)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}