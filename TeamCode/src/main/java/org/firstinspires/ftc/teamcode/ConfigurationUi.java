package org.firstinspires.ftc.teamcode;

import android.os.Environment;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

@TeleOp(name = "AutoConfigurator")
public class ConfigurationUi extends OpMode {
    private static final String PATH = (
        Environment.getExternalStorageDirectory().getAbsolutePath() + "/ftc/"
    );

    private static HashMap<Class<? extends BaseConfig>, ? extends BaseConfig> configs = (
        new HashMap<>()
    );

    private static boolean deleteConfig() {
        File file = new File(PATH);

        return file.delete();

    }

    private static boolean saveConfig() throws IOException {
        FileOutputStream file = new FileInputStream(PATH);
        ObjectInputStream configStreamOut = new ObjectInputStream(file);

        configStreamOut.writeObject(configs);
        
        configStreamOut.close();
        file.close();
    
    }

    private static boolean loadConfig() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(PATH);
        ObjectInputStream configStreamIn = new ObjectInputStream(file);
   
        configs = (HashMap<Class<? extends BaseConfig>, ? extends BaseConfig>) in.readObject();
   
        configStreamIn.close();
        file.close();

    }

    public static BaseConfig readConfigs(Class<BaseConfig> configClass) {
        return configs.get(configClass);

    }

    @Override
    public void init() {


    }

    @Override
    public void loop() {

    }

}
