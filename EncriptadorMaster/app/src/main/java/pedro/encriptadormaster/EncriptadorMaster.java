package pedro.encriptadormaster;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;


public class EncriptadorMaster extends ActionBarActivity {

    int chave = (int)(Math.random() * 256) % 256;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encriptador_master);
        TabHost tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec spec1 = tabHost.newTabSpec("Encriptador");
        spec1.setContent(R.id.encriptador);
        spec1.setIndicator("Encriptador");
        TabHost.TabSpec spec2 = tabHost.newTabSpec("Decriptador");
        spec2.setContent(R.id.decriptador);
        spec2.setIndicator("Decriptador");

        tabHost.addTab(spec1);
        tabHost.addTab(spec2);

        TextView t = (TextView) findViewById(R.id.numChave);
        t.setText(chave+"");
    }

    public void encriptarClick(View v) {
        TextView t = (TextView) findViewById(R.id.textoNormal);

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

    public void decriptarClick(View v) {
        TextView t = (TextView) findViewById(R.id.numChaveD);
        TextView t2 = (TextView) findViewById(R.id.textoEncriptadoD);
        TextView t3 = (TextView) findViewById(R.id.textoNormalD);
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
        getMenuInflater().inflate(R.menu.menu_encriptador_master, menu);
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
