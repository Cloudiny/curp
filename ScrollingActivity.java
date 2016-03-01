package saulojeda.curp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.Toast;
public class ScrollingActivity extends AppCompatActivity {
    private Spinner estadosSpiner, diaSpiner, mesSpiner, anioSpiner;
    private Button btncalcular;
    private EditText edtPNom;
    private EditText edtAma;
    private EditText edtApa;
    private TextView resultado;
    private String ape;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        edtPNom = (EditText) findViewById(R.id.edtPNom);
        setEdtApa((EditText) findViewById(R.id.edtAPa));
        edtAma = (EditText) findViewById(R.id.edtAMa);
        resultado = (TextView) findViewById(R.id.txtCurp);


        estadosSpiner = (Spinner) findViewById(R.id.spinner);
        String[] opciones = {
                "AGUASCALIENTES", "BAJA CALIFORNIA", "BAJA CALIFORNIA SUR", "CAMPECHE", "CHIAPAS",
                "CHIHUAHUA", "COAHUILA", "COLIMA", "DISTRITO FEDERAL", "DURANGO", "GUANAJUATO",
                "GUERRERO", "HIDALGO", "JALISCO", "MEXICO", "MICHOACAN", "MORELOS", "NAYARIT", "NUEVO LEON",
                "OAXACA", "PUEBLA", "QUERETARO", "QUINTANA ROO", "SAN LUIS POTOSI", "SINALOA", "SONORA",
                "TABASCO", "TAMAULIPAS", "TLAXCALA", "VERACRUZ", "YUCATÁN", "ZACATECAS", "NACIDO EXTRANJERO"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        estadosSpiner.setAdapter(adapter);

        diaSpiner = (Spinner) findViewById(R.id.spinDia);
        String[] opcionesDia = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31"
        };
        ArrayAdapter<String> adapterdias = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesDia);
        diaSpiner.setAdapter(adapterdias);

        mesSpiner = (Spinner) findViewById(R.id.spinMes);
        String[] opcionesMes = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO",
                "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"
        };

        ArrayAdapter<String> adaptermes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesMes);
        mesSpiner.setAdapter(adaptermes);

        anioSpiner = (Spinner) findViewById(R.id.spinAnio);
        String[] opcionesAnio = {"",
                "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935",
                "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951",
                "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967",
                "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984",
                "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001",
                "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016"
        };
        ArrayAdapter<String> adapteranio = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesAnio);
        anioSpiner.setAdapter(adapteranio);

        btncalcular = (Button) findViewById(R.id.btnCalcular);
        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String curp = "nada";
                String apellido = getEdtApa().getText().toString().toLowerCase();
                String vocal_ = "";
                try {
                    //   ESTE CICLO ES PARA SACAR LA PRIMERA VOCAL INTERNA DEL APELLIDO

                    for (int i = 1; i > apellido.length(); i++)
                    {
                        if (apellido.substring(i, 1).equals("a") || apellido.substring(i, 1).equals("e") || apellido.substring(i, 1).equals("i")
                                || apellido.substring(i, 1).equals("o") || apellido.substring(i, 1).equals("u"))
                                  vocal_ = apellido;
                                    i = apellido.length();

                    }
                    curp = apellido.substring(0, 1) + vocal_ + edtAma.getText().toString().toLowerCase().substring(0, 1) + edtPNom.getText().toString().toLowerCase().substring(0, 1) +
                            anioSpiner.getSelectedItem().toString() + diaSpiner.getSelectedItem().toString();

                    resultado.setText(curp);
                } catch (Exception e) {
                    Toast toast = Toast.makeText(ScrollingActivity.this, "No puedes dejar espacios en blanco", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }

        });
    }
    public void menu(View v)
    {

    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public EditText getEdtApa() {
        return edtApa;
    }

    public void setEdtApa(EditText edtApa) {
        this.edtApa = edtApa;
    }
}