////////////////////////////////////////////////////////////////////////////////
// Authors: Juan Luis Suárez Díaz, Andrés Herrera Poyatos
// Universidad de Granada, March, 2015
// Programación Orientada a Objetos - Napakalaki
////////////////////////////////////////////////////////////////////////////////

package Model;

import GUI.ExamView;

/**
 * Main for the exam.
 * @author andreshp, jlsuarez
 */
public class Exam {
    public static void main(String[] args) {
        ExamView examView = new ExamView();
        examView.showView();
    }
}
