package almudena.miprimeraapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_acerca_de.*

class AcercaDeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acerca_de)

        //Eventos botones
        // Eventos
        img_acercade_twitter.setOnClickListener { abrirURL("https://twitter.com/Almudenita16") }
        img_acercade_github.setOnClickListener { abrirURL("https://github.com/AlmudenaRA") }
    }

    // Abrir una URL
    private fun abrirURL(url: String) {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(url)
        )
        startActivity(intent)
    }
}