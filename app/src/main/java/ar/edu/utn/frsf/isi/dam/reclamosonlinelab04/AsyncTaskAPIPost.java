package ar.edu.utn.frsf.isi.dam.reclamosonlinelab04;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import ar.edu.utn.frsf.isi.dam.reclamosonlinelab04.dao.ReclamoDao;
import ar.edu.utn.frsf.isi.dam.reclamosonlinelab04.modelo.Reclamo;

/**
 * Created by npadula on 4/11/2017.
 */

public class AsyncTaskAPIPost extends AsyncTask<Context,Integer,Integer> {

    private ReclamoDao dao;
    private Reclamo reclamo;
    private String operation;
    private  Context _context;
    public  AsyncTaskAPIPost(Context c,ReclamoDao dao, Reclamo r, String operation){
        this.dao = dao;
        reclamo = r;
        this.operation = operation;
        _context = c;
    }

    @Override
    protected Integer doInBackground(Context... contexts) {
        if(operation == "CREAR"){
            dao.crear(reclamo);
        }
        else {
            //
        }
        return 0;
    }


    protected void onPostExecute(Void unused){
        String op = operation == "CREAR" ? "creacion" : "edicion";
        Toast.makeText(_context,op + "realizada con exito",Toast.LENGTH_LONG);
    }
}
