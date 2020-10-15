package almudena.miprimeraapp

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_anadir_cita.*
import java.lang.NumberFormatException


class AnadirCitaActivity : AppCompatActivity(){

    private var title: String = ""
    private var location: String = ""
    private var inicio: Long =0
    private var fin: Long =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_cita)

        btn_anadirCita_anadir.setOnClickListener{
            this.title = txt_anadirCita_title.text.toString()
            this.location = txt_anadirCita_location.text.toString()
            try{
                do{
                    this.inicio = etxtt_anadirCita_inicio.text.toString().toLong()
                    this.fin = etxtt_anadirCita_fin.text.toString().toLong()
                    if(inicio<0 && fin >24 && fin<0 && fin>24){
                        Toast.makeText(this, "No has introducido una hora", Toast.LENGTH_LONG)
                    }
                }while(inicio<0 && fin >24 && fin<0 && fin>24)

            }catch (ne: NumberFormatException){
                Toast.makeText(this, "No has introducido un número", Toast.LENGTH_LONG)
            }

            inicio = (inicio-1)*3600000
            inicio = (inicio-1)*3600000

            addEvento(title, location, inicio, fin)
        }
    }

    fun addEvento(title: String, location: String, inicio: Long, end: Long) {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, title)
            putExtra(CalendarContract.Events.EVENT_LOCATION, location)
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, inicio)
            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, fin)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }


}