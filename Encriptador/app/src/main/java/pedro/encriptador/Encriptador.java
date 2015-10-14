package pedro.encriptador;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;


public class Encriptador extends ActionBarActivity {

    int chave = (int)(Math.random() * 256) % 256;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encriptador);

        TextView t = (TextView) findViewById(R.id.numChave);
        t.setText(chave+"");
    }

    public void encriptarClick(View v) {
        TextView t = (TextView) findViewById(R.id.texto);

        char[] codificado = new char[t.getText().length()];

        String mensagem = "";

        for(int i = 0; i < t.getText().length(); i++){
            codificado[i] = (char)(t.getText().charAt(i) + chave);
            mensagem += codificado[i];
        }

        TextView t2 = (TextView) findViewById(R.id.textoEncriptado);
        t2.setText(mensagem+"");
        android.text.ClipboardManager clipboardMgr = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        clipboardMgr.setText(t2.getText());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_encriptador, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }


}
