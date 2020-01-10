package com.example.myrecyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<pictograma> lista_pictograma;
    TextToSpeech textToSpeech;
    int val ;
        //probando commit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val = 33;
        lista_pictograma = new ArrayList<>();
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        AdapterPictograma adapter = new AdapterPictograma(lista_pictograma);
        llenar_lista();
        recyclerView.setAdapter(adapter);

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if(status == TextToSpeech.SUCCESS)
                {
                    int result = textToSpeech.setLanguage(new Locale( "spa", "ESP" ));
                    if(result == TextToSpeech.LANG_MISSING_DATA || status == TextToSpeech.LANG_NOT_SUPPORTED)
                    {
                        Toast.makeText(MainActivity.this,"No soporta",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        textToSpeech.setPitch(1.0f);
                        textToSpeech.setSpeechRate(1.0f);
                    }

                }
            }
        });
    }


    void llenar_lista()
    {
        lista_pictograma.add(new pictograma(R.drawable.cambiar,getString(R.string.Titulo1),getString(R.string.Detalle01)));
        lista_pictograma.add(new pictograma(R.drawable.cambiar_1,getString(R.string.Titulo2),getString(R.string.Detalle02)));
        lista_pictograma.add(new pictograma(R.drawable.canas,getString(R.string.Titulo3),getString(R.string.Detalle03)));
        lista_pictograma.add(new pictograma(R.drawable.canoso,getString(R.string.Titulo4),getString(R.string.Detalle04)));
        lista_pictograma.add(new pictograma(R.drawable.canosos,getString(R.string.Titulo5),getString(R.string.Detalle05)));
        lista_pictograma.add(new pictograma(R.drawable.cansado,getString(R.string.Titulo6),getString(R.string.Detalle06)));
        lista_pictograma.add(new pictograma(R.drawable.cansado_1,getString(R.string.Titulo7),getString(R.string.Detalle07)));
        lista_pictograma.add(new pictograma(R.drawable.cansados,getString(R.string.Titulo8),getString(R.string.Detalle08)));
        lista_pictograma.add(new pictograma(R.drawable.cansados_1,getString(R.string.Titulo9),getString(R.string.Detalle09)));
        lista_pictograma.add(new pictograma(R.drawable.cansar,getString(R.string.Titulo10),getString(R.string.Detalle10)));
        lista_pictograma.add(new pictograma(R.drawable.cantante,getString(R.string.Titulo11),getString(R.string.Detalle11)));
        lista_pictograma.add(new pictograma(R.drawable.cantante_1,getString(R.string.Titulo12),getString(R.string.Detalle12)));
        lista_pictograma.add(new pictograma(R.drawable.cantantes,getString(R.string.Titulo13),getString(R.string.Detalle13)));
        lista_pictograma.add(new pictograma(R.drawable.cantar,getString(R.string.Titulo14),getString(R.string.Detalle14)));
        lista_pictograma.add(new pictograma(R.drawable.cantar_villancicos,getString(R.string.Titulo15),getString(R.string.Detalle15)));
        lista_pictograma.add(new pictograma(R.drawable.cara,getString(R.string.Titulo16),getString(R.string.Detalle16)));
        lista_pictograma.add(new pictograma(R.drawable.cara_a_cara,getString(R.string.Titulo17),getString(R.string.Detalle17)));
        lista_pictograma.add(new pictograma(R.drawable.chillar,getString(R.string.Titulo18),getString(R.string.Detalle18)));
        lista_pictograma.add(new pictograma(R.drawable.chillar_1,getString(R.string.Titulo19),getString(R.string.Detalle19)));
        lista_pictograma.add(new pictograma(R.drawable.chillar_2,getString(R.string.Titulo20),getString(R.string.Detalle20)));
        lista_pictograma.add(new pictograma(R.drawable.cantante,getString(R.string.Titulo21),getString(R.string.Detalle21)));
        lista_pictograma.add(new pictograma(R.drawable.aislar,getString(R.string.Titulo22),getString(R.string.Detalle22)));

    }


    public void ClickEnPictograma(int pos)
    {
        Toast.makeText(getApplicationContext(),lista_pictograma.get(pos).getPicto_detalle(),Toast.LENGTH_SHORT).show();
        speak(lista_pictograma.get(pos).getPicto_detalle());
    }

    void speak(String texto)
    {
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP)
        {
            textToSpeech.speak(texto,TextToSpeech.QUEUE_FLUSH,null,null);
        }
        else
        {
            textToSpeech.speak(texto,TextToSpeech.QUEUE_FLUSH,null);
        }

    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null)
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}
