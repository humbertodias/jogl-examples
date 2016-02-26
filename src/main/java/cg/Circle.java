package cg;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Circle implements GLEventListener {

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();

        int numVertices = 20;
        double radius = 0.5;

        // clear the window
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

//        gl.glColor3f(0, 0, 0); //set pen color to black
        // approximate  a circle with a polygon
        gl.glBegin(GL2.GL_POLYGON);
//        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        {
            double angle = 0;
            double angleIncrement = 2 * Math.PI / numVertices;
            for (int i = 0; i < numVertices; i++) {
                angle = i * angleIncrement;
                double x = radius * Math.cos(angle);
                double y = radius * Math.sin(angle);
                gl.glVertex2d(x, y);
            }
        }
        gl.glEnd();

    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        //method body
    }

    @Override
    public void init(GLAutoDrawable drawable) {

        // do any initialisation
//        GL2 gl = drawable.getGL().getGL2();
//        gl.glClearColor(1.0f, 1.0f, 1.0f, 1f); // White Background

    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
            int arg4) {
        // method body
    }

    public static void main(String ... args) {
        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        // The canvas 
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        glcanvas.addGLEventListener(new Circle());
        glcanvas.setSize(400, 400);
        //creating frame
        final JFrame frame = new JFrame("Circle");
        //adding canvas to frame
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end of main
}//end of classimport com.jogamp.opengl.GL2;
