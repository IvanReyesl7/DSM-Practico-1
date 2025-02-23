package com.example.desafio_practico1_rf210819

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Botones

        val btnSumar: Button = findViewById(R.id.sumar)
        val btnResta: Button = findViewById(R.id.resta)
        val btnMultiplicar: Button = findViewById(R.id.multiplicar)
        val btnDividir: Button = findViewById(R.id.dividir)

        //Texto

        val txtNumeroUno: TextView = findViewById(R.id.primerNumero)
        val txtNumeroDos: TextView = findViewById(R.id.segundoNumero)
        val txtResultado: TextView = findViewById(R.id.resultado)

        //Suma
        btnSumar.setOnClickListener{
            val stringNumeroUno: String = txtNumeroUno.getText().toString()
            val stringNumeroDos: String = txtNumeroDos.getText().toString()

            if (Validacion(stringNumeroUno,stringNumeroDos)){
                val numeroUno: Float = stringNumeroUno.toFloat()
                val numeroDos: Float = stringNumeroDos.toFloat()

                val resultado: Float = Sumar(numeroUno,numeroDos)
                txtResultado.text = String.format(Locale.getDefault(), "%.2f", resultado)
            }
        }

        //Resta
        btnResta.setOnClickListener{
            val stringNumeroUno: String = txtNumeroUno.getText().toString()
            val stringNumeroDos: String = txtNumeroDos.getText().toString()

            if (Validacion(stringNumeroUno,stringNumeroDos)){
                val numeroUno: Float = stringNumeroUno.toFloat()
                val numeroDos: Float = stringNumeroDos.toFloat()
                val resultado: Float = Resta(numeroUno,numeroDos)
                txtResultado.text = String.format(Locale.getDefault(), "%.2f", resultado)
            }
        }

        //Multiplicar
        btnMultiplicar.setOnClickListener{
            val stringNumeroUno: String = txtNumeroUno.getText().toString()
            val stringNumeroDos: String = txtNumeroDos.getText().toString()

            if (Validacion(stringNumeroUno,stringNumeroDos)){
                val numeroUno: Float = stringNumeroUno.toFloat()
                val numeroDos: Float = stringNumeroDos.toFloat()
                val resultado: Float = Multiplicar(numeroUno,numeroDos)
                txtResultado.text = String.format(Locale.getDefault(), "%.2f", resultado)
            }
        }

        //Dividir
        btnDividir.setOnClickListener{
            val stringNumeroUno: String = txtNumeroUno.getText().toString()
            val stringNumeroDos: String = txtNumeroDos.getText().toString()

            if (Validacion(stringNumeroUno,stringNumeroDos)){
                val numeroUno: Float = stringNumeroUno.toFloat()
                val numeroDos: Float = stringNumeroDos.toFloat()

                if (numeroDos == 0f) {
                    txtResultado.text = "No se puede dividir por cero"
                } else {
                    val resultado: Float = Dividir(numeroUno, numeroDos)
                    txtResultado.text = String.format(Locale.getDefault(), "%.2f", resultado)
                }
            }
        }
    }

    private fun Validacion(numeroUno: String?,numeroDos: String?): Boolean {

        if(numeroUno.isNullOrEmpty()){
            val toast = Toast.makeText(
                this,
                "No puede dejar la casilla vacia",
                Toast.LENGTH_SHORT)
            toast.show()

            return false
        }

        if(numeroDos.isNullOrEmpty()){
            val toast = Toast.makeText(
                this,
                "No puede dejar la casilla vacia",
                Toast.LENGTH_SHORT)
            toast.show()

            return false
        }

        return true
    }

    private fun Sumar(numeroUno: Float, numeroDos: Float): Float{
        val resultado = numeroUno + numeroDos
        return resultado
    }

    private fun Resta(numeroUno: Float, numeroDos: Float): Float{
        val resultado = numeroUno - numeroDos
        return resultado
    }

    private fun Multiplicar(numeroUno: Float, numeroDos: Float): Float{
        val resultado = numeroUno * numeroDos
        return resultado
    }

    private fun Dividir(numeroUno: Float, numeroDos: Float): Float{
        val resultado = numeroUno / numeroDos
        return resultado
    }
}