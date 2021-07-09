package anotacoes.estagiariopleno.com.anotacoes;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private EditText texto;
    private ImageView botaoSalvar;
    private static final String arquivo = "ArquivoPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperar IDs
        texto = (EditText) findViewById(R.id.textoId);
        botaoSalvar = (ImageView) findViewById(R.id.botaoSalvarId);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(arquivo,0);
                SharedPreferences.Editor editar = sharedPreferences.edit();

                editar.putString("anotacao",texto.getText().toString());
                editar.commit();
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(arquivo,0);
        if (sharedPreferences.contains("anotacao")){
            texto.setText(sharedPreferences.getString("anotacao",""));
        }
    }
}
