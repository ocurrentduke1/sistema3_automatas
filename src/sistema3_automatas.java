    import javax.swing.*;
    import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileReader;

    public class sistema3_automatas extends JFrame {
        private static final int ESTADO_INICIAL = 0;
        private static final int ESTADO_IF_INT_1 = 1;
        private static final int ESTADO_IF_2 = 2;
        private static final int ESTADO_MAIN_1 = 3;
        private static final int ESTADO_MAIN_2 = 4;
        private static final int ESTADO_MAIN_3 = 5;
        private static final int ESTADO_MAIN_4 = 6;
        private static final int ESTADO_ELSE_1 = 7;
        private static final int ESTADO_ELSE_2 = 8;
        private static final int ESTADO_ELSE_3 = 9;
        private static final int ESTADO_ELSE_4 = 10;
        private static final int ESTADO_SWITCH_1 = 11;
        private static final int ESTADO_SWITCH_2 = 12;
        private static final int ESTADO_SWITCH_3 = 13;
        private static final int ESTADO_SWITCH_4 = 14;
        private static final int ESTADO_SWITCH_5 = 15;
        private static final int ESTADO_SWITCH_6 = 16;
        private static final int ESTADO_CASE_CHAR_1 = 17;
        private static final int ESTADO_CASE_2 = 18;
        private static final int ESTADO_CASE_3 = 19;
        private static final int ESTADO_CASE_4 = 20;
        private static final int ESTADO_DEFAULT_DO_DOUBLE_1 = 21;
        private static final int ESTADO_DEFAULT_2 = 22;
        private static final int ESTADO_DEFAULT_3 = 23;
        private static final int ESTADO_DEFAULT_4 = 24;
        private static final int ESTADO_DEFAULT_5 = 25;
        private static final int ESTADO_DEFAULT_6 = 26;
        private static final int ESTADO_DEFAULT_7 = 27;
        private static final int ESTADO_FOR_1 = 28;
        private static final int ESTADO_FOR_2 = 29;
        private static final int ESTADO_FOR_3 = 30;
        private static final int ESTADO_DO_DOUBLE_2 = 31;
        private static final int ESTADO_WHILE_1 = 32;
        private static final int ESTADO_WHILE_2 = 33;
        private static final int ESTADO_WHILE_3 = 34;
        private static final int ESTADO_WHILE_4 = 35;
        private static final int ESTADO_WHILE_5 = 36;
        private static final int ESTADO_BREAK_1 = 37;
        private static final int ESTADO_BREAK_2 = 38;
        private static final int ESTADO_BREAK_3 = 39;
        private static final int ESTADO_BREAK_4 = 40;
        private static final int ESTADO_BREAK_5 = 41;
        private static final int ESTADO_INT_2 = 42;
        private static final int ESTADO_INT_3 = 43;
        private static final int ESTADO_STRING_1 = 44;
        private static final int ESTADO_STRING_2 = 45;
        private static final int ESTADO_STRING_3 = 46;
        private static final int ESTADO_STRING_4 = 47;
        private static final int ESTADO_STRING_5 = 48;
        private static final int ESTADO_STRING_6 = 49;
        private static final int ESTADO_DOUBLE_3 = 50;
        private static final int ESTADO_DOUBLE_4 = 51;
        private static final int ESTADO_DOUBLE_5 = 52;
        private static final int ESTADO_DOUBLE_6 = 53;
        private static final int ESTADO_CHAR_2 = 54;
        private static final int ESTADO_CHAR_3 = 55;
        private static final int ESTADO_CHAR_4 = 56;
        private static final int ESTADO_PRINT_1 = 57;
        private static final int ESTADO_PRINT_2 = 58;
        private static final int ESTADO_PRINT_3 = 59;
        private static final int ESTADO_PRINT_4 = 60;
        private static final int ESTADO_PRINT_5 = 61;
        private static final int ESTADO_RELACIONAL_MENOR_IGUAL_1 = 62;
        private static final int ESTADO_RELACIONAL_MENOR_IGUAL_2 = 63;
        private static final int ESTADO_RELACIONAL_MAYOR_IGUAL_1 = 64;
        private static final int ESTADO_RELACIONAL_MAYOR_IGUAL_2 = 65;
        private static final int ESTADO_RELACIONAL_IGUAL_1 = 66;
        private static final int ESTADO_RELACIONAL_DIFERENCIA_NEGACION_1 = 67;
        private static final int ESTADO_RELACIONAL_DIFERENCIA_2 = 68;
        private static final int ESTADO_ASIGNACION_1 = 69;
        private static final int ESTADO_AND_1 = 70;
        private static final int ESTADO_AND_2 = 71;
        private static final int ESTADO_OR_1 = 72;
        private static final int ESTADO_OR_2 = 73;
        private static final int ESTADO_ARITMETICO_SUMA_INCREMENTO_1 = 74;
        private static final int ESTADO_ARITMETICO_RESTA_DECREMENTO_1 = 75;
        private static final int ESTADO_ARITMETICO_DIVISION_COMENTARIO_SIMPLE_1 = 76;
        private static final int ESTADO_ARITMETICO_MULTI_1 = 77;
        private static final int ESTADO_ARITMETICO_MODULO_1 = 78;
        private static final int ESTADO_INCREMENTO_2 = 79;
        private static final int ESTADO_DECREMENTO_2 = 80;
        private static final int ESTADO_COMENTARIO_SIMPLE_2 = 81;
        private static final int ESTADO_NUMERO_ENTERO_DECIMAL_1 = 82;
        private static final int ESTADO_NUMERO_DECIMAL_2 = 83;
        private static final int ESTADO_ERROR = 84;
        private static final int ESTADO_PARENTESIS_ABIERTO = 85;
        private static final int ESTADO_PARENTESIS_CERRADO = 86;
        private static final int ESTADO_CADENA_ABIERTA = 87;
        private static final int ESTADO_CADENA_CERRADA = 88;
        private static final int ESTADO_COMENTARIO_BLOQUE_1 = 89;
        private static final int ESTADO_COMENTARIO_BLOQUE_2 = 90;
        private static final int ESTADO_LLAVE_ABIERTA = 91;
        private static final int ESTADO_LLAVE_CERRADA = 92;
        private static final int ESTADO_IDENTIFICADORES = 93;

        private int estadoActual;
        private int contadorPalabrasReservadas, contadorRelacionales, contadorAsignacion,
                contadorLogico, contadorIncremento, contadorAritmetico, contadorDecimales,
                contadorDecremento, contadorComentarioSimple, contadorEnteros,contadorParentesis,
                contadorCadena, contadorComentarioBloque,contadorLlaves, contadorIdentificadores,
                contadorErrores;
        private boolean stateParentesis = false;
        private boolean stateLlaves = false;
        private boolean stateComentBox = false;
        private boolean stateCadena = false;

        private JTextArea texto;

        public sistema3_automatas() {
            super("Sistema Palabras Reservadas");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(1500, 700); // Establecer el tamaño de la ventana
            setLayout(null); // Usar un layout nulo para controlar las dimensiones manualmente
            setLocationRelativeTo(null); // Centrar la ventana en la pantalla

            // Crear el JTextArea
            texto = new JTextArea();
            texto.setBounds(10, 10, 1000, 600); // Establecer las dimensiones del JTextArea
            texto.setLineWrap(true); // Establecer el salto de línea al llegar al borde
            texto.setWrapStyleWord(true); // Establecer si el salto se hará por espacios en blanco o por caracteres
            add(texto);

            // Crear el JScrollPane y agregar el JTextArea
            JScrollPane scrollPane = new JScrollPane(texto);
            scrollPane.setBounds(10, 10, 1000, 600); // Establecer las dimensiones del JScrollPane
            add(scrollPane);

            // Crear el botón
            JButton botonCargar = new JButton("Cargar archivo");
            botonCargar.setBounds(10, 620, 120, 30); // Establecer las dimensiones del botón
            botonCargar.addActionListener(e -> cargarArchivo());
            add(botonCargar);

            // Etiqueta para las palabras reservadas
            JLabel PalabrasReservadas = new JLabel("Palabras reservadas: 0");
            JLabel Relacionales = new JLabel("Operadores relacionales: 0");
            JLabel Asignacion = new JLabel("Asignaciones: 0");
            JLabel logicos = new JLabel("Operadores logicos: 0");
            JLabel aritmeticos = new JLabel("Operadores Aritmeticos: 0");
            JLabel identificadores = new JLabel("Identificadores: 0");
            JLabel enteros = new JLabel("Numeros enteros: 0");
            JLabel decimales = new JLabel("Numeros decimales: 0");
            JLabel incremento = new JLabel("Incrementos: 0");
            JLabel decremento = new JLabel("Decrementos: 0");
            JLabel cadena = new JLabel("Cadenas de caracteres: 0");
            JLabel comentarioBox = new JLabel("Comentarios: 0");
            JLabel comentarioLine = new JLabel("Comentarios simples: 0");
            JLabel parentesis = new JLabel("Parentesis: 0");
            JLabel llaves = new JLabel("Llaves: 0");
            JLabel errores = new JLabel("Errores: 0");
            PalabrasReservadas.setBounds(1050, 10, 200, 30);
            identificadores.setBounds(1050, 30, 200, 30);
            Relacionales.setBounds(1050, 50, 200, 30);
            logicos.setBounds(1050, 70, 200, 30);
            aritmeticos.setBounds(1050, 90, 200, 30);
            Asignacion.setBounds(1050, 110, 200, 30);
            enteros.setBounds(1050, 130, 200, 30);
            decimales.setBounds(1050, 150, 200, 30);
            incremento.setBounds(1050, 170, 200, 30);
            decremento.setBounds(1050, 190, 200, 30);
            cadena.setBounds(1050, 210, 200, 30);
            comentarioBox.setBounds(1050, 230, 200, 30);
            comentarioLine.setBounds(1050, 250, 200, 30);
            parentesis.setBounds(1050, 270, 200, 30);
            llaves.setBounds(1050, 290, 200, 30);
            errores.setBounds(1050, 310, 200, 30);

            add(PalabrasReservadas);
            add(Relacionales);
            add(Asignacion);
            add(logicos);
            add(identificadores);
            add(aritmeticos);
            add(enteros);
            add(decimales);
            add(incremento);
            add(decremento);
            add(cadena);
            add(comentarioBox);
            add(comentarioLine);
            add(parentesis);
            add(llaves);
            add(errores);

            // Crear el botón
            JButton botonAnalizar = new JButton("Analizar");
            botonAnalizar.setBounds(140, 620, 160, 30); // Establecer las dimensiones del botón
            botonAnalizar.addActionListener(e -> {
                String textoAnalizar = texto.getText();
                analizar(textoAnalizar);
                PalabrasReservadas.setText("Palabras reservadas: " + contadorPalabrasReservadas);
                Relacionales.setText("Operadores relacionales: " + contadorRelacionales);
                Asignacion.setText("Asignaciones: " + contadorAsignacion);
                logicos.setText("Operadores Logicos: " + contadorLogico);
                aritmeticos.setText("Operadores aritmeticos: "+ contadorAritmetico);
                enteros.setText("Numeros enteros: "+ contadorEnteros);
                incremento.setText("Incrementos: "+ contadorIncremento);
                decremento.setText("Decrementos: "+ contadorDecremento);
                decimales.setText("Numeros decimales: " + contadorDecimales);
                comentarioLine.setText("Comentarios simples: " + contadorComentarioSimple);
                parentesis.setText("Parentesis: " + contadorParentesis);
                cadena.setText("Cadenas de caracteres: " + contadorCadena);
                comentarioBox.setText("Comentarios: " + contadorComentarioBloque);
                llaves.setText("Llaves: "+ contadorLlaves);
                identificadores.setText("Identificadores: " + contadorIdentificadores);
                errores.setText("Errores: " + contadorErrores);

            });
            add(botonAnalizar);

            setVisible(true);
        }

        private void cargarArchivo() {
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File archivoSeleccionado = fileChooser.getSelectedFile();
                try {
                    FileReader fr = new FileReader(archivoSeleccionado);
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    texto.setText(""); // Limpiar el JTextArea antes de cargar el archivo
                    while ((linea = br.readLine()) != null) {
                        texto.append(linea + "\n"); // Agregar cada línea al JTextArea
                    }
                    br.close();
                } catch (Exception ex) {
                    System.err.println("Error al cargar el archivo: " + ex.getMessage());
                }
            }
        }

        public void analizar(String texto) {
            // Reiniciar contadores
            contadorPalabrasReservadas = 0;
            contadorRelacionales = 0;
            contadorAsignacion = 0;
            contadorLogico = 0;
            contadorIncremento = 0;
            contadorDecremento = 0;
            contadorComentarioSimple = 0;
            contadorAritmetico = 0;
            contadorEnteros = 0;
            contadorDecimales = 0;
            contadorParentesis = 0;
            contadorCadena = 0;
            contadorComentarioBloque = 0;
            contadorLlaves = 0;
            contadorIdentificadores = 0;
            contadorErrores = 0;
            estadoActual = ESTADO_INICIAL;

            char[] caracteres = texto.toCharArray();
            for (int i = 0; i < caracteres.length; i++) {
                char caracter = caracteres[i];
                switch (estadoActual) {
                    case ESTADO_INICIAL:
                        if (caracter == 'i') estadoActual = ESTADO_IF_INT_1;
                        else if (caracter == 'm') estadoActual = ESTADO_MAIN_1;
                        else if (caracter == 'e') estadoActual = ESTADO_ELSE_1;
                        else if (caracter == 's') estadoActual = ESTADO_SWITCH_1;
                        else if (caracter == 'c') estadoActual = ESTADO_CASE_CHAR_1;
                        else if (caracter == 'd') estadoActual = ESTADO_DEFAULT_DO_DOUBLE_1;
                        else if (caracter == 'f') estadoActual = ESTADO_FOR_1;
                        else if (caracter == 'w') estadoActual = ESTADO_WHILE_1;
                        else if (caracter == 'b') estadoActual = ESTADO_BREAK_1;
                        else if (caracter == 'S') estadoActual = ESTADO_STRING_1;
                        else if (caracter == 'p') estadoActual = ESTADO_PRINT_1;
                        else if (caracter == '<') estadoActual = ESTADO_RELACIONAL_MENOR_IGUAL_1;
                        else if (caracter == '>') estadoActual = ESTADO_RELACIONAL_MAYOR_IGUAL_1;
                        else if (caracter == '=') estadoActual = ESTADO_ASIGNACION_1;
                        else if (caracter == '!') estadoActual = ESTADO_RELACIONAL_DIFERENCIA_NEGACION_1;
                        else if (caracter == '&') estadoActual = ESTADO_AND_1;
                        else if (caracter == '|') estadoActual = ESTADO_OR_1;
                        else if (caracter == '+') estadoActual = ESTADO_ARITMETICO_SUMA_INCREMENTO_1;
                        else if (caracter == '-') estadoActual = ESTADO_ARITMETICO_RESTA_DECREMENTO_1;
                        else if (caracter == '/') estadoActual = ESTADO_ARITMETICO_DIVISION_COMENTARIO_SIMPLE_1;
                        else if (caracter == '%') estadoActual = ESTADO_ARITMETICO_MODULO_1;
                        else if (caracter == '*') estadoActual = ESTADO_ARITMETICO_MULTI_1;
                        else if (caracter == '(') estadoActual = ESTADO_PARENTESIS_ABIERTO;
                        else if (caracter == ')') estadoActual = ESTADO_PARENTESIS_CERRADO;
                        else if (caracter == '"') estadoActual = ESTADO_CADENA_ABIERTA;
                        else if (caracter == '{') estadoActual = ESTADO_LLAVE_ABIERTA;
                        else if (caracter == '}') estadoActual = ESTADO_LLAVE_CERRADA;
                        else if (Character.isDigit(caracter)) estadoActual = ESTADO_NUMERO_ENTERO_DECIMAL_1;
                        else if (Character.isLetter(caracter)) estadoActual = ESTADO_IDENTIFICADORES;
                        else if (caracter == ' ') estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_IF_INT_1:
                        if (caracter == 'f') estadoActual = ESTADO_IF_2;
                        else if (caracter == 'n') estadoActual = ESTADO_INT_2;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_IF_2:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorPalabrasReservadas++;
                            estadoActual = ESTADO_INICIAL;
                        }else if (Character.isLetter(caracter)) estadoActual = ESTADO_IDENTIFICADORES;
                        else {
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;
                    case ESTADO_MAIN_1:
                        if (caracter == 'a') estadoActual = ESTADO_MAIN_2;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_MAIN_2:
                        if (caracter == 'i') estadoActual = ESTADO_MAIN_3;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_MAIN_3:
                        if (caracter == 'n') estadoActual = ESTADO_MAIN_4;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_MAIN_4:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorPalabrasReservadas++;
                            estadoActual = ESTADO_INICIAL;
                        }else if (Character.isLetter(caracter)) estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_ELSE_1:
                        if (caracter == 'l') estadoActual = ESTADO_ELSE_2;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_ELSE_2:
                        if (caracter == 's') estadoActual = ESTADO_ELSE_3;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_ELSE_3:
                        if (caracter == 'e') estadoActual = ESTADO_ELSE_4;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_ELSE_4:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorPalabrasReservadas++;
                            estadoActual = ESTADO_INICIAL;
                        }else if (Character.isLetter(caracter)) estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_SWITCH_1:
                        if (caracter == 'w') estadoActual = ESTADO_SWITCH_2;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_SWITCH_2:
                        if (caracter == 'i') estadoActual = ESTADO_SWITCH_3;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_SWITCH_3:
                        if (caracter == 't') estadoActual = ESTADO_SWITCH_4;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_SWITCH_4:
                        if (caracter == 'c') estadoActual = ESTADO_SWITCH_5;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_SWITCH_5:
                        if (caracter == 'h') estadoActual = ESTADO_SWITCH_6;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_SWITCH_6:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorPalabrasReservadas++;
                            estadoActual = ESTADO_INICIAL;
                        }else if (Character.isLetter(caracter)) estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_CASE_CHAR_1:
                        if (caracter == 'a') estadoActual = ESTADO_CASE_2;
                        else if (caracter == 'h') estadoActual = ESTADO_CHAR_2;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_CASE_2:
                        if (caracter == 's') estadoActual = ESTADO_CASE_3;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_CASE_3:
                        if (caracter == 'e') estadoActual = ESTADO_CASE_4;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_CASE_4:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorPalabrasReservadas++;
                            estadoActual = ESTADO_INICIAL;
                        }else if (Character.isLetter(caracter)) estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_DEFAULT_DO_DOUBLE_1:
                        if (caracter == 'e') estadoActual = ESTADO_DEFAULT_2;
                        else if (caracter == 'o') estadoActual = ESTADO_DO_DOUBLE_2;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_DEFAULT_2:
                        if (caracter == 'f') estadoActual = ESTADO_DEFAULT_3;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_DEFAULT_3:
                        if (caracter == 'a') estadoActual = ESTADO_DEFAULT_4;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_DEFAULT_4:
                        if (caracter == 'u') estadoActual = ESTADO_DEFAULT_5;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_DEFAULT_5:
                        if (caracter == 'l') estadoActual = ESTADO_DEFAULT_6;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_DEFAULT_6:
                        if (caracter == 't') estadoActual = ESTADO_DEFAULT_7;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_DEFAULT_7:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorPalabrasReservadas++;
                            estadoActual = ESTADO_INICIAL;
                        }else if (Character.isLetter(caracter)) estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;

                        break;
                    case ESTADO_FOR_1:
                        if (caracter == 'o') estadoActual = ESTADO_FOR_2;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_FOR_2:
                        if (caracter == 'r') estadoActual = ESTADO_FOR_3;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_FOR_3:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorPalabrasReservadas++;
                            estadoActual = ESTADO_INICIAL;
                        }else if (Character.isLetter(caracter)) estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;

                        break;
                    case ESTADO_DO_DOUBLE_2:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorPalabrasReservadas++;
                            estadoActual = ESTADO_INICIAL;
                        } else if (caracter == 'u') estadoActual = ESTADO_DOUBLE_3;
                        else if (Character.isLetter(caracter)) estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;

                        break;
                    case ESTADO_WHILE_1:
                        if (caracter == 'h') estadoActual = ESTADO_WHILE_2;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_WHILE_2:
                        if (caracter == 'i') estadoActual = ESTADO_WHILE_3;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_WHILE_3:
                        if (caracter == 'l') estadoActual = ESTADO_WHILE_4;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_WHILE_4:
                        if (caracter == 'e') estadoActual = ESTADO_WHILE_5;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_WHILE_5:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorPalabrasReservadas++;
                            estadoActual = ESTADO_INICIAL;
                        }else if (Character.isLetter(caracter)) estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;

                        break;
                    case ESTADO_BREAK_1:
                        if (caracter == 'r') estadoActual = ESTADO_BREAK_2;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_BREAK_2:
                        if (caracter == 'e') estadoActual = ESTADO_BREAK_3;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_BREAK_3:
                        if (caracter == 'a') estadoActual = ESTADO_BREAK_4;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_BREAK_4:
                        if (caracter == 'k') estadoActual = ESTADO_BREAK_5;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_BREAK_5:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorPalabrasReservadas++;
                            estadoActual = ESTADO_INICIAL;
                        }else if (Character.isLetter(caracter)) estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;

                        break;
                    case ESTADO_INT_2:
                        if (caracter == 't') estadoActual = ESTADO_INT_3;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_INT_3:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorPalabrasReservadas++;
                            estadoActual = ESTADO_INICIAL;
                        }else if (Character.isLetter(caracter)) estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;

                        break;
                    case ESTADO_STRING_1:
                        if (caracter == 't') estadoActual = ESTADO_STRING_2;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_STRING_2:
                        if (caracter == 'r') estadoActual = ESTADO_STRING_3;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_STRING_3:
                        if (caracter == 'i') estadoActual = ESTADO_STRING_4;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_STRING_4:
                        if (caracter == 'n') estadoActual = ESTADO_STRING_5;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_STRING_5:
                        if (caracter == 'g') estadoActual = ESTADO_STRING_6;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_STRING_6:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorPalabrasReservadas++;
                            estadoActual = ESTADO_INICIAL;
                        }else if (Character.isLetter(caracter)) estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;

                        break;
                    case ESTADO_DOUBLE_3:
                        if (caracter == 'b') estadoActual = ESTADO_DOUBLE_4;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;

                        break;
                    case ESTADO_DOUBLE_4:
                        if (caracter == 'l') estadoActual = ESTADO_DOUBLE_5;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_DOUBLE_5:
                        if (caracter == 'e') estadoActual = ESTADO_DOUBLE_6;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_DOUBLE_6:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorPalabrasReservadas++;
                            estadoActual = ESTADO_INICIAL;
                        }else if (Character.isLetter(caracter)) estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;

                        break;
                    case ESTADO_CHAR_2:
                        if (caracter == 'a') estadoActual = ESTADO_CHAR_3;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_CHAR_3:
                        if (caracter == 'r') estadoActual = ESTADO_CHAR_4;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_CHAR_4:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorPalabrasReservadas++;
                            estadoActual = ESTADO_INICIAL;
                        }else if (Character.isLetter(caracter)) estadoActual = ESTADO_IDENTIFICADORES;
                        else {
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;
                    case ESTADO_PRINT_1:
                        if (caracter == 'r') estadoActual = ESTADO_PRINT_2;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_PRINT_2:
                        if (caracter == 'i') estadoActual = ESTADO_PRINT_3;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_PRINT_3:
                        if (caracter == 'n') estadoActual = ESTADO_PRINT_4;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_PRINT_4:
                        if (caracter == 't') estadoActual = ESTADO_PRINT_5;
                        else if (Character.isLetter(caracter) || caracter == ' ') estadoActual = ESTADO_IDENTIFICADORES;
                        else estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_PRINT_5:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorPalabrasReservadas++;
                            estadoActual = ESTADO_INICIAL;
                        }else if (Character.isLetter(caracter)) estadoActual = ESTADO_IDENTIFICADORES;
                        else {
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;
                    case ESTADO_RELACIONAL_MENOR_IGUAL_1:
                        if (caracter == '=') {
                            estadoActual = ESTADO_RELACIONAL_MENOR_IGUAL_2;
                        } else if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorRelacionales++;
                            estadoActual = ESTADO_INICIAL;
                        } else {
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;

                    case ESTADO_RELACIONAL_MENOR_IGUAL_2:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorRelacionales++;
                            estadoActual = ESTADO_INICIAL;
                        } else {
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;
                    case ESTADO_RELACIONAL_MAYOR_IGUAL_1:
                        if (caracter == '=') {
                            estadoActual = ESTADO_RELACIONAL_MAYOR_IGUAL_2;
                        } else if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorRelacionales++;
                            estadoActual = ESTADO_INICIAL;
                        } else {
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;

                    case ESTADO_RELACIONAL_MAYOR_IGUAL_2:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                        contadorRelacionales++;
                        estadoActual = ESTADO_INICIAL;
                        }else {
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;
                    case ESTADO_ASIGNACION_1:
                        if (caracter == '=') {
                            estadoActual = ESTADO_RELACIONAL_IGUAL_1;
                        } else if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1){
                            contadorAsignacion++;
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;

                    case ESTADO_RELACIONAL_IGUAL_1:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorRelacionales++;
                            estadoActual = ESTADO_INICIAL;
                        }else {
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;

                    case ESTADO_RELACIONAL_DIFERENCIA_NEGACION_1:
                        if (caracter == '=') {
                            estadoActual = ESTADO_RELACIONAL_DIFERENCIA_2;
                        } else if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1){
                            contadorLogico++;
                            estadoActual = ESTADO_INICIAL;  // No es un operador distinto, ignoramos
                        }else {
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;

                    case ESTADO_RELACIONAL_DIFERENCIA_2:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorRelacionales++;
                            estadoActual = ESTADO_INICIAL;
                        }else {
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;
                    case ESTADO_AND_1:
                        if (caracter == '&') {
                            estadoActual = ESTADO_AND_2;
                        } else {
                            estadoActual = ESTADO_INICIAL;  // No es un operador &&, ignoramos
                        }
                        break;

                    case ESTADO_AND_2:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorLogico++;
                            estadoActual = ESTADO_INICIAL;
                        }else {
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;
                    case ESTADO_OR_1:
                        if (caracter == '|') {
                            estadoActual = ESTADO_OR_2;
                        } else {
                            estadoActual = ESTADO_INICIAL;  // No es un operador &&, ignoramos
                        }
                        break;

                    case ESTADO_OR_2:
                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorLogico++;
                            estadoActual = ESTADO_INICIAL;
                        }else{
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;
                    case ESTADO_ARITMETICO_SUMA_INCREMENTO_1:
                        if (caracter == '+') {
                            estadoActual = ESTADO_INCREMENTO_2;
                        } else if(caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1){
                            contadorAritmetico++;
                            estadoActual = ESTADO_INICIAL;
                        }else {
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;

                    case ESTADO_INCREMENTO_2:
                        if(caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorIncremento++;
                            estadoActual = ESTADO_INICIAL;
                        }else {
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;

                    case ESTADO_ARITMETICO_RESTA_DECREMENTO_1:
                        if (caracter == '-') {
                            estadoActual = ESTADO_DECREMENTO_2;
                        } else if(caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1){
                            contadorAritmetico++;
                            estadoActual = ESTADO_INICIAL;
                        }else if(Character.isDigit(caracter)){
                            estadoActual = ESTADO_NUMERO_ENTERO_DECIMAL_1;
                        }else{
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;

                    case ESTADO_DECREMENTO_2:
                        if(caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1) {
                            contadorDecremento++;
                            estadoActual = ESTADO_INICIAL;
                        }else {
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;
                    case ESTADO_ARITMETICO_DIVISION_COMENTARIO_SIMPLE_1:
                        if (caracter == '/') {
                            estadoActual = ESTADO_COMENTARIO_SIMPLE_2;
                        } else if(caracter == '*'){
                            stateComentBox = true;
                            estadoActual = ESTADO_COMENTARIO_BLOQUE_1;
                        } else if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1){
                            contadorAritmetico++;
                            estadoActual = ESTADO_INICIAL;
                        }else {
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;

                    case ESTADO_COMENTARIO_SIMPLE_2:
                        if(caracter != '\n' ){
                            // Permanecer en el mismo estado mientras no se detecte un salto de linea
                        }else {
                            contadorComentarioSimple++;
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;

                    case ESTADO_ARITMETICO_MODULO_1:
                        contadorAritmetico++;
                        estadoActual = ESTADO_INICIAL;
                        break;

                    case ESTADO_ARITMETICO_MULTI_1:
                        contadorAritmetico++;
                        estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_NUMERO_ENTERO_DECIMAL_1:
                        if (Character.isDigit(caracter)) {
                            // Permanecer en el mismo estado mientras se detecten dígitos
                        } else if(caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1){
                            contadorEnteros++;
                            estadoActual = ESTADO_INICIAL;
                        } else if (caracter == '.') {
                            estadoActual = ESTADO_NUMERO_DECIMAL_2;
                        }
                        break;
                    case ESTADO_NUMERO_DECIMAL_2:
                        if(Character.isDigit(caracter)){
                            // Permanecer en el mismo estado mientras se detecten dígitos
                        }else if (caracter == '.'){
                            estadoActual = ESTADO_ERROR;
                        } else if (caracter == ' ' || caracter == '\n' || caracter == '\t' || i == caracteres.length - 1){
                            contadorDecimales++;
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;
                    case ESTADO_ERROR:
                        if(caracter == ' ' || caracter == '\n' || caracter == '\t'){
                            contadorErrores++;
                            estadoActual = ESTADO_INICIAL;
                        }else {
                            // Permanecer en el mismo estado mientras se detecten dígitos
                        }
                        break;
                    case ESTADO_PARENTESIS_ABIERTO:
                        contadorParentesis++;
                        stateParentesis = true;
                        estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_PARENTESIS_CERRADO:
                        contadorParentesis++;
                        stateParentesis = false;
                        estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_CADENA_ABIERTA:
                        if(caracter == '"'){
                            stateCadena = true;
                            estadoActual = ESTADO_CADENA_CERRADA;
                        }else{
                            //continuar en este estado hasta encontrar otras comillas
                        }
                        break;
                    case ESTADO_CADENA_CERRADA:
                        contadorCadena++;
                        stateCadena = false;
                        estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_COMENTARIO_BLOQUE_1:
                        if(caracter != '*'){
                            //mantener el estado hasta encontrar un asterisco
                        }else{
                            estadoActual = ESTADO_COMENTARIO_BLOQUE_2;
                        }
                        break;
                    case ESTADO_COMENTARIO_BLOQUE_2:
                        if(caracter == '/'){
                            contadorComentarioBloque++;
                            stateComentBox = false;
                            estadoActual = ESTADO_INICIAL;
                        }else{
                            estadoActual = ESTADO_COMENTARIO_BLOQUE_1;
                        }
                        break;
                    case ESTADO_LLAVE_ABIERTA:
                            contadorLlaves++;
                            stateLlaves = true;
                            estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_LLAVE_CERRADA:
                            contadorLlaves++;
                            stateLlaves = false;
                            estadoActual = ESTADO_INICIAL;
                        break;
                    case ESTADO_IDENTIFICADORES:
                        if (Character.isLetterOrDigit(caracter)) {
                            // Mantenerse en el estado de identificadores
                        } else if(caracter == '_'){
                            //mantenerse en el estado actual
                        } else if (caracter == ' ' || caracter == '\n' || caracter == '\t') {
                            contadorIdentificadores++;
                            estadoActual = ESTADO_INICIAL;
                        }
                        break;
                }
            }
            if(stateParentesis){
                contadorErrores++;
            }
            if(stateLlaves){
                contadorErrores++;
            }
            if(stateCadena){
                contadorErrores++;
            }
            if(stateComentBox){
                contadorErrores++;
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(sistema3_automatas::new);
        }
    }
