package almudena.miprimeraapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_anadir_contacto.*

class MainActivity : AppCompatActivity() {

    private var nombre: String = ""
    private var correo: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    //Creación del menú
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Opciones a pulsar un estado del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.main_menu_anadirNota -> {
                menuAnadirNota()
                true
            }
            R.id.main_menu_mandarEmail -> {
                menuMandarCorreo()
                true
            }
            R.id.main_menu_anadirAmigo -> {
                menuAnadirAmigo()
                true
            }
            R.id.main_menu_anadirCita -> {
                menuAnadirCita()
                true
            }
            R.id.main_menu_acercaDe -> {
                menuAcercaDe()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Muestra la actividad Añadir nota
    private fun menuAnadirNota() {
        val intent = Intent(this, AnadirNotaActivity::class.java)
        startActivity(intent)
    }

    // Muestra la actividad Mandar correo
    private fun menuMandarCorreo() {
        val intent = Intent(this, MandarCorreoActivity::class.java)
        startActivity(intent)
    }

    // Muestra la actividad Añadir amigo
    private fun menuAnadirAmigo() {
        val intent = Intent(this, AnadirContactoActivity::class.java)
        startActivity(intent)
    }
    // Muestra la actividad Añadir cita
    private fun menuAnadirCita() {
        val intent = Intent(this, AnadirCitaActivity::class.java)
        startActivity(intent)
    }

    // Muestra la actividad Acerca De
    private fun menuAcercaDe() {
        val intent = Intent(this, AcercaDeActivity::class.java)
        startActivity(intent)
    }


}