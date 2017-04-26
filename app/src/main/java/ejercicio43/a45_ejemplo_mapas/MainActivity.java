package ejercicio43.a45_ejemplo_mapas;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    GoogleMap gm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //obtenemos una referencia al fragmento que contiene el mapa
        FragmentManager fm=this.getSupportFragmentManager();
        SupportMapFragment smf=(SupportMapFragment)fm.findFragmentById(R.id.mapa);
        smf.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                gm=googleMap;
                //tipo de mapa
                gm.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                //habilitar controles
                gm.getUiSettings().setZoomControlsEnabled(true);
                //habilitar barra de herramientas
                gm.getUiSettings().setMapToolbarEnabled(true);
                //habilitar la localizacion
                gm.getUiSettings().setMyLocationButtonEnabled(true);
                //posicionar en una determinada localización
                LatLng pos=new LatLng(40.3960965,-3.743638);
                gm.moveCamera(CameraUpdateFactory.newLatLngZoom(pos,18));
                //añadir un marcador
                MarkerOptions mk=new MarkerOptions();
                mk.position(pos);
                mk.title("centro de formación");
                gm.addMarker(mk);




                //respuesta a evento click en el marcador
                gm.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        Toast.makeText(MainActivity.this,marker.getTitle(),Toast.LENGTH_LONG).show();

                        return false;
                    }
                });

            }
        });
    }
}
