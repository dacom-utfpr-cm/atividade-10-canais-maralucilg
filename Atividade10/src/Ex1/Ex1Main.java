
package Ex1;

import java.io.IOException;
import java.nio.channels.Pipe;

/**
 * 1. Implementar o problema do produtor-consumidor usando Java NIO: 
 * Pipe, Pipe.SinkChannel e Pipe.SourceChannel.
 * 
 * @maralucilg
 */
public class Ex1Main {
    
    public static void main(String[] args) throws IOException {
        
        Pipe pipeChannel = Pipe.open();
        int NUM_THREADS = 3;
        
        for(int i = 0; i < NUM_THREADS; i++) {
            
            Thread t = new Thread(new Cons(pipeChannel.source()), i + " ");
            t.start();
        }
        
        new Prod(pipeChannel.sink(), 1000).run();
    }
    
}
