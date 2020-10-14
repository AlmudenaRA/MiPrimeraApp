package almudena.miprimeraapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
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
            R.id.main_menu_añadirNota -> {
                menuAcercaDe()
                true
            }
            R.id.main_menu_mandarEmail -> {
                menuOtraOpcion()
                true
            }
            R.id.main_menu_añadirAmigo -> {
                menuOtraOpcion()
                true
            }
            R.id.main_menu_anadirCita -> {
                menuOtraOpcion()
                true
            }
            R.id.main_menu_acercaDe -> {
                menuAcercaDe()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Muestra la actividad Acerca De
    private fun menuAcercaDe() {
        val intent = Intent(this, AcercaDeActivity::class.java)
        startActivity(intent)
    }
}