package abacus.pulles.com.annotateyou;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class CanvasActivity extends Activity {
    MyCanvas myCanvas;
    AlertDialog.Builder ab;
    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        myCanvas = findViewById(R.id.mycanvas);
    }
    public void clearCanvas(View v){
        myCanvas.clearCanvas();
    }

    public void onBackPressed() {
            ab = new AlertDialog.Builder(CanvasActivity.this);
            ab.setTitle("Confirm").
                    setMessage("Are you sure you want to exit").
                    setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog = ab.create();
            alertDialog.show();
        }

}

