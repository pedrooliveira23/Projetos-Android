package pedro.decriptador;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Decriptador extends ActionBarActivity {
    int chave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decriptador);
    }

    public void decriptarClick(View v) {
        TextView t = (TextView) findViewById(R.id.numChave);
        TextView t2 = (TextView) findViewById(R.id.textoEncriptado);
        TextView t3 = (TextView) findViewById(R.id.textoDecriptado);
        chave = Integer.parseInt(t.getText().toString());
        char[] decodificado = new char[t2.getText().length()];
        String mensagem = "";

        for(int i = 0; i < t2.getText().length(); i++){
            decodificado[i] = (char)(t2.getText().charAt(i) - chave);
            mensagem += decodificado[i];
        }

        t3.setText(mensagem+"");

        android.text.ClipboardManager clipboardMgr = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        clipboardMgr.setText(t3.getText());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_decriptador, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
