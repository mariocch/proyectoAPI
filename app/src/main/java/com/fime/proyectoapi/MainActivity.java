package com.fime.proyectoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvCarrera, tvNombre, tvMatricula;
    Button btnConsultar;
    private RequestQueue mQueue;
    ListView lvEstudiantes;
    Estudiante estudiante;
    ArrayList<Estudiante> estudiantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCarrera = findViewById(R.id.tvCarrera);
        tvNombre = findViewById(R.id.tvNombre);
        tvMatricula = findViewById(R.id.tvMatricula);

        btnConsultar = findViewById(R.id.buttonParse);

        lvEstudiantes = findViewById(R.id.lvEstudiantes);

        mQueue = Volley.newRequestQueue(getApplicationContext());

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
                btnConsultar.setVisibility(View.GONE);
            }
        });
    }

    private void jsonParse() {
        String url = "https://api.myjson.com/bins/lysp6";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                estudiantes = new ArrayList<>();
                try {
                    JSONArray jsonArray = response.getJSONArray("alumnos");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject alumnos = jsonArray.getJSONObject(i);

                        String nombre = alumnos.getString("nombre");
                        String matricula = alumnos.getString("matricula");
                        String carrera = alumnos.getString("carrera");

                        estudiantes.add(new Estudiante(carrera,nombre,matricula));

                        /*tvCarrera.append(carrera + "\n\n");
                        tvNombre.append(nombre + "\n\n");
                        tvMatricula.append(matricula + "\n\n");*/
                    }

                    ListViewAdapter adapter = new ListViewAdapter(getApplicationContext(), estudiantes);
                    lvEstudiantes.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
}
