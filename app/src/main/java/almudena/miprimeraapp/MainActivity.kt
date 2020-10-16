package almudena.miprimeraapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_anadir_contacto.*

class MainActivity : AppCompatActivity() {

    private var nombre: String = ""
    private var currentScore = 1
    private var currentLevel = 1
    private var colors = arrayOfNulls<String>(0)

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


    // Para salvar el estado por ejemplo es usando un Bundle en el ciclo de vida
    override fun onSaveInstanceState(outState: Bundle) {
        // Salvamos en un bundle estas variables o estados de la interfaz
        outState.run {
            // Actualizamos los datos o los recogemos de la interfaz
            currentScore *= 2
            currentLevel++
            putInt("PUNTUACION", currentScore)
            putInt("NIVEL", currentLevel)
            putString("NOMBRE", nombre)
            putStringArray("COLORES", colors);
            Log.i("CICLO", "Salvando el estado con Puntuación: $currentScore - nivel: $currentLevel - $nombre")
        }
        // Siempre se llama a la superclase para salvar as cosas
        super.onSaveInstanceState(outState)
    }

    // Para recuperar el estado al volver al un estado de ciclo de vida de la Interfaz
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Recuperamos en un bundle estas variables o estados de la interfaz
        super.onRestoreInstanceState(savedInstanceState)
        // Recuperamos del Bundle
        savedInstanceState.run {
            currentScore = getInt("PUNTUACION")
            currentLevel = getInt("NIVEL")
            nombre = getString("NOMBRE").toString()
            Log.i("CICLO", "Recuperando el estado con Puntuación: $currentScore - nivel: $currentLevel - $nombre")
        }
    }
}