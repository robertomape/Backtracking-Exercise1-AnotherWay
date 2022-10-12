public class Algoritmo {
    public void vueltaatras(int[] vector, int objetivo){
        int suma = 0;
        Booleano exito = new Booleano(false);
        int nivel = 0;
        int[] sol = new int[vector.length];
        for(int i = 0; i < sol.length;i++){
            sol[i] = 0;
        }
        vueltaatrasAux(vector,objetivo,nivel,exito,suma,sol);
    }
    public void vueltaatrasAux(int[] vector,int objetivo, int nivel, Booleano exito,int suma, int[] solucion ){
        if(vector.length == nivel){
            if( suma== objetivo){
                exito.setValor(true);
                System.out.println("Conseguido");
                for(int i = 0; i < solucion.length;i++){
                    System.out.println(solucion[i]);
                }
            }
        }
        else{
            int c = 0;
            while(!exito.getValor() && (c<2)) {
                if (c == 0 || (suma + vector[nivel]) <= objetivo) {
                    suma = suma + vector[nivel] * c;
                    solucion[nivel] = c;
                    nivel++;
                    vueltaatrasAux(vector, objetivo, nivel, exito, suma, solucion);
                    if (!exito.getValor()) {
                        nivel--;
                        solucion[nivel] = 0;
                        suma = suma - vector[nivel] * c;
                    }
                }
                c++;
            }
        }
    }
}
