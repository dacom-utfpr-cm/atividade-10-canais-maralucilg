
package Ex1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe consumidora.
 * 
 *  Tutoriais utilizados:
 * https://www.tutorialspoint.com/java_nio/java_nio_pipe.htm
 * https://www.geeksforgeeks.org/buffer-rewind-methods-in-java-with-examples/
 * 
 * @maralucilg
 */
public class Cons implements Runnable {
    
   Pipe.SourceChannel Source;
   ByteBuffer buffer = ByteBuffer.allocate(100);
   
   public Cons(Pipe.SourceChannel Source){
       this.Source = Source;
   }

    @Override
    public void run() {
        
        while(true){
            
            try {
                Source.read(buffer);
                buffer.rewind();
            } catch (IOException ex) {
                ex.printStackTrace();
                
            }
            
            System.out.println(Thread.currentThread().getName() + " >> Consumindo..." + buffer.getInt());
        }
       
        
    }
    
}
