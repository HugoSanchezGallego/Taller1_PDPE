import android.content.Context
import android.os.AsyncTask
import android.widget.Toast

@Suppress("DEPRECATION")
class CombinedTask(private val context: Context) : AsyncTask<Void, Int, String>() {

    override fun doInBackground(vararg params: Void?): String {
        for (i in 1..20) {
            Thread.sleep(5000) // Simula una operación de red
            publishProgress(i * 5)
        }
        return "Operación completada"
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        Toast.makeText(context, "Progreso: ${values[0]}%", Toast.LENGTH_SHORT).show()
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
    }
}