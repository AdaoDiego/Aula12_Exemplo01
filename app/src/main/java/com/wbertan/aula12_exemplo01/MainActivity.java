package com.wbertan.aula12_exemplo01;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final int NOTIFICATION_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void criarNotificacao(View view) {
        Intent notificationIntent = new Intent(this, NotificationReceiverActivity.class);
        Intent tela01Intent = new Intent(this, Tela01.class);
        Intent tela02Intent = new Intent(this, Tela02.class);

        // usando System.currentTimeMillis() você terá um ID único para a pending intent
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), notificationIntent, 0);
        PendingIntent tela01PendingIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), tela01Intent, 0);
        PendingIntent tela02PendingIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), tela02Intent, 0);

        Notification.Action action01 = new Notification.Action.Builder(R.drawable.icone_acao_01, "Ação 01", tela01PendingIntent).build();
        Notification.Action action02 = new Notification.Action.Builder(R.drawable.icone_acao_02, "Ação 02", tela02PendingIntent).build();

        String textoPequeno = "Este é só um exemplo de notificação!";
        String textoGrande = "Este é só um exemplo de notificação! Mas que este é o texto grande, muito grande, e que ficaria enorme na nossa notificação! Assim vamos continuar escrevendo nosso texto gigante para validar e ver como que fica na nossa notificação!";
        Notification notification = new Notification.Builder(this)
                .setContentTitle("Aula12 - Exemplo01")
                .setContentText(textoPequeno)
                .setStyle(new Notification.BigTextStyle().bigText(textoGrande))
                .setSmallIcon(R.drawable.icone_notificacao)
                .setContentIntent(notificationPendingIntent)
                .setAutoCancel(true)
                .addAction(action01)
                .addAction(action02)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //Se colocar o mesmo ID ele substitui o anterior (se tiver uma notificação já)
        //   se colocar um novo ID, ele cria outra notificação...
        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}
