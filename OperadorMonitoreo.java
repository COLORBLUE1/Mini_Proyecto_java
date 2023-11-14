package clases;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class OperadorMonitoreo {
    // Inicializar el sistema de video captura.
    private VideoCapture webSource = null;

    // Constructor.
    public OperadorMonitoreo() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    // Iniciar el video.
    public void iniciarVideo() {
        webSource = new VideoCapture();
        if (webSource.open(0)) {
            System.out.println("Iniciando video.");
        } else {
            System.out.println("No se pudo abrir el video.");
        }
    }

    // Parar el video.
    public void pararVideo() {
        if (webSource != null) {
            webSource.release();
            System.out.println("Video detenido.");
        }
    }

    // Obtener el siguiente frame del video.
    public Mat capturarFrame() {
        Mat frame = new Mat();
        if (webSource.isOpened()) {
            boolean success = webSource.read(frame);
            if (!success) {
                System.out.println("No se pudo obtener el frame del video.");
            }
        }
        return frame;
    }

    // Mostrar el video en tiempo real.
    public void mostrarVideo() {
        if (webSource.isOpened()) {
            Mat frame = capturarFrame();
            Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2RGB);
            MatOfByte matOfByte = new MatOfByte();
            Imgcodecs.imencode(".jpg", frame, matOfByte);
            byte[] byteArray = matOfByte.toArray();
            BufferedImage bufferedImage = null;
            try {
                InputStream in = new ByteArrayInputStream(byteArray);
                bufferedImage = ImageIO.read(in);
                JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(bufferedImage)));
            } catch (IOException ex) {
                Logger.getLogger(OperadorMonitoreo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Monitorear el video.
    public void monitorearVideo() {
        // Iniciar el video.
        iniciarVideo();

        // Crear un bucle para mostrar el video en tiempo real.
        while (true) {
            // Mostrar el video.
            mostrarVideo();

            // Si se presiona la tecla "q", detener el video.
            if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
                break;
            }
        }

        // Parar el video.
        pararVideo();
    }

    public static void main(String[] args) {
        OperadorMonitoreo operadorMonitoreo = new OperadorMonitoreo();
        operadorMonitoreo.monitorearVideo();
    }
}