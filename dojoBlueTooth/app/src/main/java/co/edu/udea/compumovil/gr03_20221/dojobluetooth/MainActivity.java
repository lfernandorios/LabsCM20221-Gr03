package co.edu.udea.compumovil.gr03_20221.dojobluetooth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;

    TextView mStatusBlueTv, mPairedTv;
    ImageView mBlueIv;
    Button mOnBtn, mOffBtn, mDiscoverBtn, mPairedBtn;

    BluetoothAdapter mBlueAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStatusBlueTv = findViewById(R.id.statusBluetoothTv);
        mPairedTv = findViewById(R.id.pairedTv);
        mBlueIv = findViewById(R.id.bluetoothIv);
        mOnBtn = findViewById(R.id.onBtn);
        mOffBtn = findViewById(R.id.offBtn);
        mDiscoverBtn = findViewById(R.id.discoverableBtn);
        mPairedBtn = findViewById(R.id.pairedBtn);

        mBlueAdapter = BluetoothAdapter.getDefaultAdapter();

        if(mBlueAdapter == null){
            mStatusBlueTv.setText( "BlueTooth no disponible");

        } else {
            mStatusBlueTv.setText("BlueTooth Disponible");

        }

        if(mBlueAdapter.isEnabled()){
            mBlueIv.setImageResource(R.drawable.ic_bluetooth_on_foreground);
        } else {
            mBlueIv.setImageResource(R.drawable.ic_bluetooth_off_foreground);
        }

        mOnBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                if(!mBlueAdapter.isEnabled()){
                    showToast("Encendiendo el BlueTooth");
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intent, REQUEST_ENABLE_BT);
                } else {
                    showToast("Bluetooth ya se encuentra encendido");
                }
            }
        });

        mDiscoverBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                if(!mBlueAdapter.isDiscovering()){
                    showToast("Haciendo Visible el Dispositivo");
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(intent, REQUEST_DISCOVER_BT);
                }
            }
        });

        mOffBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                if(mBlueAdapter.isEnabled()){
                    mBlueAdapter.disable();
                    showToast("Apagando el BlueTooth");
                    mBlueIv.setImageResource(R.drawable.ic_bluetooth_off_foreground);
                } else {
                    showToast("El BlueTooth ya está apagado");
                }
            }
        });

        mPairedBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                if(mBlueAdapter.isEnabled()){
                    mPairedTv.setText("Dispositivos Emparejados");
                    Set<BluetoothDevice> devices = mBlueAdapter.getBondedDevices();
                    for (BluetoothDevice device: devices)
                    {
                        mPairedTv.append("\n Dipositivos:  " + device.getName() + ", " +device);
                        
                    }

                } else {
                    showToast("Encienda el BlueTooth para actualizar la lista de dispositivos");
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        switch (requestCode){
            case REQUEST_ENABLE_BT:
                if(requestCode == RESULT_OK){
                    mBlueIv.setImageResource(R.drawable.ic_bluetooth_on_foreground);
                    showToast("BlueTooth encendido");
                } else {
                    showToast("No se puede encender el BlueTooth");
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}