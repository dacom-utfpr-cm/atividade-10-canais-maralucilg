
package Ex1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;


/**
 * Classe Produtora.
 * 
 * @maralucilg
 */
public class Prod implements Runnable {
    
    Pipe.SinkChannel Sink;
    ByteBuffer buffer = ByteBuffer.allocate(100);
    int n;
    
  public Prod(Pipe.SinkChannel Sink, int n) {
      this.Sink = Sink;
      this.n = n;
  }
    

    @Override
    public void run() {

        for(int i = 0; i < n; i++){
            
            buffer.clear();
            buffer.putInt(i);
            
            try {
                this.Sink.write(buffer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            System.out.println(">>" + "produzindo..." + i);
        }
      
    }
    
}
