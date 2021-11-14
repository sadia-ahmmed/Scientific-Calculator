
package calculator;

import java.awt.Color;
import javax.swing.ButtonGroup;



public class calculator extends javax.swing.JFrame {
    
    double result=0,temp=0,input=0;
    String inputNumber = "", sign = "", op = "";
    boolean power = true;
    //ButtonGroup G = new ButtonGroup();
    //void degOn(){
        //jRadioButton1.setEnabled(true);
        //jRadioButton2.setEnabled(false);
       // jRadioButton3.setEnabled(false);
    //}
    void power(){
        if(power){
            ac();
            power = false;
            jButtonOnOf.setBackground(Color.red);
        }
        else {
            power = true;
            jButtonOnOf.setBackground(Color.green);
        }
    }

    public void input(String s){
        
        if(power){
            if(s.equals("0") || s.equals("1")|| s.equals("2")|| s.equals("3")|| s.equals("4")|| s.equals("5")|| s.equals("6")|| s.equals("7")|| s.equals("8")|| s.equals("9")){
                jTextFieldInput.setText(jTextFieldInput.getText()+s);
                inputNumber+=s;
            }
            else if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("=")){
                if(!inputNumber.equals("")){
                    tempCalculate();
                    Calculate();
                }
                jTextFieldSign.setText(s);
                jTextFieldInput.setText("");
                inputNumber = "";
                op = "";
                jTextFieldOP.setText("");
                long newANS;
                newANS = (long) result;
                if(newANS<999999999){
                jTextFieldOutput.setText(Double.toString(result));
                }else
                    jTextFieldOutput.setText("Infinity");
                sign = s;
            }
        
            else if(s.equals("sqrt") || s.equals("3√x") || s.equals("3√x") || s.equals("MOD") || s.equals("y√x") || s.equals("squre")|| s.equals("+ / -") || s.equals("1/x") || s.equals("cube") || s.equals("power") || s.equals("log") || s.equals("ln") || s.equals("%") || s.equals("*10^") || s.equals("sin^-") || s.equals("cos^-") || s.equals("tan^-") || s.equals("!") || s.equals("e^")){
                op = s;
                jTextFieldOP.setText(s);
            }
            else if(s.equals("sin")|| s.equals("cos") || s.equals("tan")){
            
                op = s;
                jTextFieldOP.setText(s);
                
            }
        
            else if(s.equals("Ans")){
                inputNumber = Double.toString(result);
                jTextFieldInput.setText("Ans");
            }
        
        
            else if(s.equals(".")){
                if(!dotcheck()){
                    jTextFieldInput.setText(jTextFieldInput.getText()+s);
                    inputNumber+=s;
                }
            }
            
        }
        
    }
    
    
    
    void tempCalculate(){
        if(op.equals("sqrt")){
            input = Double.parseDouble(inputNumber);
            temp = Math.sqrt(input);
        }else if(op.equals("+ / -")){
            input = Double.parseDouble(inputNumber);
            temp = input*-1;
        }else if(op.equals("^-1")){
            input = Double.parseDouble(inputNumber);
            temp= Math.pow(input,-1);
        }
        else if(op.equals("MOD")){
            input = Double.parseDouble(inputNumber);
            temp= (result% input);
        }
         else if(op.equals("1/x")){
            input = Double.parseDouble(inputNumber);
            temp = Math.pow(input, -1);
        }else if(op.equals("y√x")){
            input = Double.parseDouble(inputNumber);
            //temp = Math.sqrt(input);
            double t=1/input;
            temp = Math.round(Math.pow(result,t));
        }
         else if(op.equals("3√x")){
            input = Double.parseDouble(inputNumber);
            temp = Math.cbrt(input);
        }
        else if(op.equals("1/x")){
            input = Double.parseDouble(inputNumber);
            temp = Math.pow(input, -1);
        }else if(op.equals("cube")){
            input = Double.parseDouble(inputNumber);
            temp = Math.pow(input, 3);
        }
        else if(op.equals("squre")){
            input = Double.parseDouble(inputNumber);
            temp = Math.pow(input, 2);
        }
        else if(op.equals("power")){
            input = Double.parseDouble(inputNumber);
            temp = Math.pow(result, input);
        }
        else if(op.equals("log")){
            input = Double.parseDouble(inputNumber);
            temp = Math.log10(input);
        }
        else if(op.equals("ln")){
            input = Double.parseDouble(inputNumber);
            temp = Math.log(input);
        }
        else if(op.equals("%")){
            input = Double.parseDouble(inputNumber);
            temp = input/100;
        }
        else if(op.equals("*10^")){
            input = Double.parseDouble(inputNumber);
            temp = Math.pow(10,input);
        }
        else if(op.equals("sin^-")){
            input = Double.parseDouble(inputNumber);
            temp = Math.toDegrees(Math.asin(input));
        }
        else if(op.equals("cos^-")){
            input = Double.parseDouble(inputNumber);
            temp = Math.toDegrees(Math.acos(input));
        }
        else if(op.equals("tan^-")){
            input = Double.parseDouble(inputNumber);
            temp = Math.toDegrees(Math.atan(input));
        }
        else if(op.equals("!")){
            input = Double.parseDouble(inputNumber);
            temp = factorial((int)input);
        }
        else if(op.equals("e^")){
            input = Double.parseDouble(inputNumber);
            temp = Math.exp(input);
        }
        else if(op.equals("sin")){
            input = Double.parseDouble(inputNumber);
            temp = Math.sin(Math.toRadians(input));
        }
        else if(op.equals("cos")){
            input = Double.parseDouble(inputNumber);
            if(Math.cos(Math.toRadians(input))>0.00009)
            temp = Math.cos(Math.toRadians(input));
            else temp=0;
        }
        else if(op.equals("tan")){
            input = Double.parseDouble(inputNumber);
            temp = (Math.tan(Math.toRadians(input)));
        }
        else{
            temp = Double.parseDouble(inputNumber);
        }
    }
    
    
    void Calculate(){
        if(sign.equals("+")){
            result+=temp;
        }
        else if(sign.equals("-")){
            result-=temp;
        }
        else if(sign.equals("*")){
            result*=temp;
        }
        else if(sign.equals("/")){
            result/=temp;
        }
        
        else{
            result = temp;
        }
    }

    void ac(){
        result = 0;
        temp = 0;
        input = 0;
        inputNumber = "";
        sign = ""; 
        op = "";
        jTextFieldOutput.setText("");
        jTextFieldInput.setText("");
        jTextFieldSign.setText("");
        jTextFieldOP.setText("");
        
    }
    
    
    void del(){
        String s = jTextFieldInput.getText();
        if(s.length()>0){
            s = removeCharAt(s,s.length()-1);
            jTextFieldInput.setText(s);
        }
        if(inputNumber.length()>0){
            inputNumber = removeCharAt(inputNumber,inputNumber.length()-1);
            
        }
        
    }
    
    
    boolean dotcheck(){
        String str = jTextFieldInput.getText();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='.'){
                return true;
            }
        }
        return false;
    }
    
    long factorial(int N)
    {
        long multi = 1;
        for (int i = 1; i <= N; i++) {
            multi = multi * i;
        }
        return multi;
    }
    
    public calculator() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextFieldInput = new javax.swing.JTextField();
        jButton0 = new javax.swing.JButton();
        jButtonDot = new javax.swing.JButton();
        jButton10X = new javax.swing.JButton();
        jButtonEqual = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButtonPlus = new javax.swing.JButton();
        jButtonMinus = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButtonMul = new javax.swing.JButton();
        jButtonDiv = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButtonDel = new javax.swing.JButton();
        jButtonAc = new javax.swing.JButton();
        jButtonSqrt = new javax.swing.JButton();
        jButtonSqr = new javax.swing.JButton();
        jButtonPs = new javax.swing.JButton();
        jButtonPower = new javax.swing.JButton();
        jButtonLog = new javax.swing.JButton();
        jButtonSinI = new javax.swing.JButton();
        jButtonCosI = new javax.swing.JButton();
        jButtonSin = new javax.swing.JButton();
        jButtonCos = new javax.swing.JButton();
        jButtonLn = new javax.swing.JButton();
        jButtonTanI = new javax.swing.JButton();
        jButtonTan = new javax.swing.JButton();
        jButtonFact = new javax.swing.JButton();
        jButtonOnOf = new javax.swing.JButton();
        jTextFieldOutput = new javax.swing.JTextField();
        jTextFieldSign = new javax.swing.JTextField();
        jTextFieldOP = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButtonAc1 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scientific Calculator");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldInput.setEditable(false);
        jTextFieldInput.setBackground(new java.awt.Color(214, 217, 223));
        jTextFieldInput.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jTextFieldInput.setBorder(null);
        jTextFieldInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInputActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 550, 20));

        jButton0.setText("0");
        jButton0.setToolTipText("");
        jButton0.setAlignmentX(0.5F);
        jButton0.setAutoscrolls(true);
        jButton0.setBorderPainted(false);
        jButton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton0ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton0, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 120, -1));

        jButtonDot.setText(".");
        jButtonDot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDotActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDot, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 60, -1));

        jButton10X.setText("x10^");
        jButton10X.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton10X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10XActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10X, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 61, -1));

        jButtonEqual.setText("=");
        jButtonEqual.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonEqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEqualActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEqual, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 49, 70));

        jButton1.setText("1");
        jButton1.setToolTipText("");
        jButton1.setAlignmentX(0.5F);
        jButton1.setAutoscrolls(true);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 61, -1));

        jButton2.setText("2");
        jButton2.setToolTipText("");
        jButton2.setAlignmentX(0.5F);
        jButton2.setAutoscrolls(true);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 61, -1));

        jButton3.setText("3");
        jButton3.setToolTipText("");
        jButton3.setAlignmentX(0.5F);
        jButton3.setAutoscrolls(true);
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 61, -1));

        jButtonPlus.setText("+");
        jButtonPlus.setToolTipText("");
        jButtonPlus.setAlignmentX(0.5F);
        jButtonPlus.setAutoscrolls(true);
        jButtonPlus.setBorderPainted(false);
        jButtonPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlusActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPlus, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 60, -1));

        jButtonMinus.setText("-");
        jButtonMinus.setToolTipText("");
        jButtonMinus.setAlignmentX(0.5F);
        jButtonMinus.setAutoscrolls(true);
        jButtonMinus.setBorderPainted(false);
        jButtonMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinusActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMinus, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 60, -1));

        jButton4.setText("4");
        jButton4.setToolTipText("");
        jButton4.setAlignmentX(0.5F);
        jButton4.setAutoscrolls(true);
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 61, -1));

        jButton5.setText("5");
        jButton5.setToolTipText("");
        jButton5.setAlignmentX(0.5F);
        jButton5.setAutoscrolls(true);
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 61, -1));

        jButton6.setText("6");
        jButton6.setToolTipText("");
        jButton6.setAlignmentX(0.5F);
        jButton6.setAutoscrolls(true);
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 61, -1));

        jButtonMul.setText("x");
        jButtonMul.setToolTipText("");
        jButtonMul.setAlignmentX(0.5F);
        jButtonMul.setAutoscrolls(true);
        jButtonMul.setBorderPainted(false);
        jButtonMul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMulActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMul, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 60, -1));

        jButtonDiv.setText("/");
        jButtonDiv.setToolTipText("");
        jButtonDiv.setAlignmentX(0.5F);
        jButtonDiv.setAutoscrolls(true);
        jButtonDiv.setBorderPainted(false);
        jButtonDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDivActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDiv, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 60, -1));

        jButton7.setText("7");
        jButton7.setToolTipText("");
        jButton7.setAlignmentX(0.5F);
        jButton7.setAutoscrolls(true);
        jButton7.setBorderPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 61, -1));

        jButton8.setText("8");
        jButton8.setToolTipText("");
        jButton8.setAlignmentX(0.5F);
        jButton8.setAutoscrolls(true);
        jButton8.setBorderPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 61, -1));

        jButton9.setText("9");
        jButton9.setToolTipText("");
        jButton9.setAlignmentX(0.5F);
        jButton9.setAutoscrolls(true);
        jButton9.setBorderPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 61, -1));

        jButtonDel.setText("DEL");
        jButtonDel.setToolTipText("");
        jButtonDel.setAlignmentX(0.5F);
        jButtonDel.setAutoscrolls(true);
        jButtonDel.setBorderPainted(false);
        jButtonDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 61, -1));

        jButtonAc.setText("C");
        jButtonAc.setToolTipText("");
        jButtonAc.setAlignmentX(0.5F);
        jButtonAc.setAutoscrolls(true);
        jButtonAc.setBorderPainted(false);
        jButtonAc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAc, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 61, -1));

        jButtonSqrt.setText("√");
        jButtonSqrt.setToolTipText("");
        jButtonSqrt.setAlignmentX(0.5F);
        jButtonSqrt.setAutoscrolls(true);
        jButtonSqrt.setBorderPainted(false);
        jButtonSqrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSqrtActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSqrt, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 50, -1));

        jButtonSqr.setText("x^2");
        jButtonSqr.setToolTipText("");
        jButtonSqr.setAlignmentX(0.5F);
        jButtonSqr.setAutoscrolls(true);
        jButtonSqr.setBorderPainted(false);
        jButtonSqr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSqrActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSqr, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 61, -1));

        jButtonPs.setText("%");
        jButtonPs.setToolTipText("");
        jButtonPs.setAlignmentX(0.5F);
        jButtonPs.setAutoscrolls(true);
        jButtonPs.setBorderPainted(false);
        jButtonPs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPsActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPs, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, 49, -1));

        jButtonPower.setText("x^");
        jButtonPower.setToolTipText("");
        jButtonPower.setAlignmentX(0.5F);
        jButtonPower.setAutoscrolls(true);
        jButtonPower.setBorderPainted(false);
        jButtonPower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPowerActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPower, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 61, -1));

        jButtonLog.setText("log");
        jButtonLog.setToolTipText("");
        jButtonLog.setAlignmentX(0.5F);
        jButtonLog.setAutoscrolls(true);
        jButtonLog.setBorderPainted(false);
        jButtonLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 61, -1));

        jButtonSinI.setText("sin^-");
        jButtonSinI.setToolTipText("");
        jButtonSinI.setAlignmentX(0.5F);
        jButtonSinI.setAutoscrolls(true);
        jButtonSinI.setBorderPainted(false);
        jButtonSinI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSinIActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSinI, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 61, -1));

        jButtonCosI.setText("cos^-");
        jButtonCosI.setToolTipText("");
        jButtonCosI.setAlignmentX(0.5F);
        jButtonCosI.setAutoscrolls(true);
        jButtonCosI.setBorderPainted(false);
        jButtonCosI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCosIActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCosI, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        jButtonSin.setText("sin");
        jButtonSin.setToolTipText("");
        jButtonSin.setAlignmentX(0.5F);
        jButtonSin.setAutoscrolls(true);
        jButtonSin.setBorderPainted(false);
        jButtonSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSinActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 61, -1));

        jButtonCos.setText("cos");
        jButtonCos.setToolTipText("");
        jButtonCos.setAlignmentX(0.5F);
        jButtonCos.setAutoscrolls(true);
        jButtonCos.setBorderPainted(false);
        jButtonCos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 61, -1));

        jButtonLn.setText("ln");
        jButtonLn.setToolTipText("");
        jButtonLn.setAlignmentX(0.5F);
        jButtonLn.setAutoscrolls(true);
        jButtonLn.setBorderPainted(false);
        jButtonLn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLnActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 61, -1));

        jButtonTanI.setText("tan^-");
        jButtonTanI.setToolTipText("");
        jButtonTanI.setAlignmentX(0.5F);
        jButtonTanI.setAutoscrolls(true);
        jButtonTanI.setBorderPainted(false);
        jButtonTanI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTanIActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTanI, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        jButtonTan.setText("tan");
        jButtonTan.setToolTipText("");
        jButtonTan.setAlignmentX(0.5F);
        jButtonTan.setAutoscrolls(true);
        jButtonTan.setBorderPainted(false);
        jButtonTan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTanActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 61, -1));

        jButtonFact.setText("n!");
        jButtonFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFactActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFact, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 61, -1));

        jButtonOnOf.setBackground(java.awt.Color.green);
        jButtonOnOf.setText("ON / OFF");
        jButtonOnOf.setToolTipText("");
        jButtonOnOf.setAlignmentX(0.5F);
        jButtonOnOf.setAutoscrolls(true);
        jButtonOnOf.setBorderPainted(false);
        jButtonOnOf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOnOfActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonOnOf, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 80, 20));

        jTextFieldOutput.setEditable(false);
        jTextFieldOutput.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        jTextFieldOutput.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOutputActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, 550, 60));

        jTextFieldSign.setEditable(false);
        jTextFieldSign.setBackground(new java.awt.Color(214, 217, 223));
        jTextFieldSign.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        jTextFieldSign.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSign.setBorder(null);
        getContentPane().add(jTextFieldSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 56, 90, 39));

        jTextFieldOP.setEditable(false);
        jTextFieldOP.setBackground(new java.awt.Color(214, 217, 223));
        jTextFieldOP.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jTextFieldOP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldOP.setBorder(null);
        jTextFieldOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOPActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldOP, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 11, 90, 39));

        jButton10.setText("1/x");
        jButton10.setBorderPainted(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, -1, -1));

        jButton11.setText("+ / -");
        jButton11.setBorderPainted(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 60, -1));

        jButtonAc1.setText("CE");
        jButtonAc1.setToolTipText("");
        jButtonAc1.setAlignmentX(0.5F);
        jButtonAc1.setAutoscrolls(true);
        jButtonAc1.setBorderPainted(false);
        jButtonAc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAc1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 61, -1));

        jButton12.setText("F-E");
        jButton12.setBorderPainted(false);
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 60, -1));

        jButton13.setText("EXP");
        jButton13.setBorderPainted(false);
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 60, -1));

        jButton14.setText("(");
        jButton14.setBorderPainted(false);
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 60, -1));

        jButton15.setText(")");
        jButton15.setBorderPainted(false);
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 60, -1));

        jButton16.setText("x^3");
        jButton16.setToolTipText("");
        jButton16.setBorderPainted(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 60, -1));

        jButton17.setText("y√ x");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 60, -1));

        jButton18.setText("3√ x");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 60, -1));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Grads");
        jRadioButton3.setBorderPainted(true);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Degrees");
        jRadioButton1.setBorderPainted(true);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Radians");
        jRadioButton2.setBorderPainted(true);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 310, 40));

        jButton19.setText("MC");
        jButton19.setBorderPainted(false);
        getContentPane().add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 60, -1));

        jButton20.setText("MR");
        jButton20.setBorderPainted(false);
        getContentPane().add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 60, -1));

        jButton21.setText("MS");
        jButton21.setBorderPainted(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 60, -1));

        jButton22.setText("M+");
        jButton22.setBorderPainted(false);
        getContentPane().add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 60, -1));

        jButton23.setText("M-");
        jButton23.setBorderPainted(false);
        getContentPane().add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 50, -1));

        jButton24.setText("MOD");
        jButton24.setBorderPainted(false);
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 340, 60, -1));

        jButton25.setText("Inv");
        jButton25.setBorderPainted(false);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 180, 60, -1));

        jButton26.setText("Int");
        jButton26.setBorderPainted(false);
        getContentPane().add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 60, -1));

        jButton27.setText("dms");
        jButton27.setBorderPainted(false);
        getContentPane().add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 60, -1));

        jButton28.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton28.setText("π");
        jButton28.setBorderPainted(false);
        getContentPane().add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 300, 60, -1));

        jMenu1.setText("View");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldInputActionPerformed

    private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton0ActionPerformed
        input("0");
    }//GEN-LAST:event_jButton0ActionPerformed

    private void jButtonEqualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEqualActionPerformed
        input("=");
    }//GEN-LAST:event_jButtonEqualActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        input("1");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        input("2");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        input("3");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlusActionPerformed
        input("+");
    }//GEN-LAST:event_jButtonPlusActionPerformed

    private void jButtonMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinusActionPerformed
        input("-");
    }//GEN-LAST:event_jButtonMinusActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        input("4");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        input("5");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        input("6");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButtonMulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMulActionPerformed
        input("*");
    }//GEN-LAST:event_jButtonMulActionPerformed

    private void jButtonDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDivActionPerformed
        input("/");
    }//GEN-LAST:event_jButtonDivActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        input("7");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        input("8");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        input("9");
    }//GEN-LAST:event_jButton9ActionPerformed
    
    
    
    
    //Delete char from string
    public static String removeCharAt(String s, int pos) {
      return s.substring(0, pos) + s.substring(pos + 1);
   }
    
    private void jButtonDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelActionPerformed
        del();
        
    }//GEN-LAST:event_jButtonDelActionPerformed

    private void jButtonAcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcActionPerformed
        ac();
    }//GEN-LAST:event_jButtonAcActionPerformed

    private void jButtonSqrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSqrtActionPerformed
        input("sqrt");
    }//GEN-LAST:event_jButtonSqrtActionPerformed

    private void jButtonSqrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSqrActionPerformed
        input("squre");
    }//GEN-LAST:event_jButtonSqrActionPerformed

    private void jButtonPsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPsActionPerformed
        input("%");
    }//GEN-LAST:event_jButtonPsActionPerformed

    private void jButtonPowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPowerActionPerformed
        input("power");
    }//GEN-LAST:event_jButtonPowerActionPerformed

    private void jButtonLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogActionPerformed
        input("log");
    }//GEN-LAST:event_jButtonLogActionPerformed

    private void jButtonSinIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSinIActionPerformed
        input("sin^-");
    }//GEN-LAST:event_jButtonSinIActionPerformed

    private void jButtonCosIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCosIActionPerformed
        input("cos^-");
    }//GEN-LAST:event_jButtonCosIActionPerformed

    private void jButtonSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSinActionPerformed
        input("sin");
    }//GEN-LAST:event_jButtonSinActionPerformed

    private void jButtonCosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCosActionPerformed
        input("cos");
    }//GEN-LAST:event_jButtonCosActionPerformed

    private void jButtonLnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLnActionPerformed
        input("ln");
    }//GEN-LAST:event_jButtonLnActionPerformed

    private void jButtonTanIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTanIActionPerformed
        input("tan^-");
    }//GEN-LAST:event_jButtonTanIActionPerformed

    private void jButtonTanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTanActionPerformed
        input("tan");
    }//GEN-LAST:event_jButtonTanActionPerformed

    private void jButtonOnOfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOnOfActionPerformed
        power();
    }//GEN-LAST:event_jButtonOnOfActionPerformed

    private void jTextFieldOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOutputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOutputActionPerformed

    private void jButtonDotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDotActionPerformed
        input(".");
    }//GEN-LAST:event_jButtonDotActionPerformed

    private void jButton10XActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10XActionPerformed
        input("*10^");
    }//GEN-LAST:event_jButton10XActionPerformed

    private void jButtonFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFactActionPerformed
        input("!");
    }//GEN-LAST:event_jButtonFactActionPerformed

    private void jButtonAc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAc1ActionPerformed
        ac();
    }//GEN-LAST:event_jButtonAc1ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        input("cube");
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        input("+ / -");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        input("1/x");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        input("3√x");
        
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        input("y√x");
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        input("MOD");
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        input("^-1");
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        //degOn();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTextFieldOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOPActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton0;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton10X;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonAc;
    private javax.swing.JButton jButtonAc1;
    private javax.swing.JButton jButtonCos;
    private javax.swing.JButton jButtonCosI;
    private javax.swing.JButton jButtonDel;
    private javax.swing.JButton jButtonDiv;
    private javax.swing.JButton jButtonDot;
    private javax.swing.JButton jButtonEqual;
    private javax.swing.JButton jButtonFact;
    private javax.swing.JButton jButtonLn;
    private javax.swing.JButton jButtonLog;
    private javax.swing.JButton jButtonMinus;
    private javax.swing.JButton jButtonMul;
    private javax.swing.JButton jButtonOnOf;
    private javax.swing.JButton jButtonPlus;
    private javax.swing.JButton jButtonPower;
    private javax.swing.JButton jButtonPs;
    private javax.swing.JButton jButtonSin;
    private javax.swing.JButton jButtonSinI;
    private javax.swing.JButton jButtonSqr;
    private javax.swing.JButton jButtonSqrt;
    private javax.swing.JButton jButtonTan;
    private javax.swing.JButton jButtonTanI;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField jTextFieldInput;
    private javax.swing.JTextField jTextFieldOP;
    private javax.swing.JTextField jTextFieldOutput;
    private javax.swing.JTextField jTextFieldSign;
    // End of variables declaration//GEN-END:variables
}
