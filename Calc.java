public class Calc extends Compf {
    private StackInt s;
    private static int char2int(char c) {
        return (int)c - (int)'0';
    }
    protected int symOther(char c) {
        if (c < '0' || c > '8') {
            System.out.println("Недопустимый символ: " + c);
            System.exit(0);
        }
        return SYM_OTHER;
    }

    protected void nextOper(char c) {
        int second = s.pop();
        int first = s.pop();
        switch (c) {
            case '+':
                s.push(first + second); break;
            case '-':
                s.push(first - second); break;
            case '*':
                s.push(first * second); break;
            case '/':
                s.push(first / second); break;
        }
    }
    protected void nextOther(char c) {

        if(N){
             int chisl = ((s.pop())*8)+char2int(c);
             s.push(chisl);
             N = true;
        }
        else {
            s.push(char2int(c));
            N = true;
        }
    }
    public Calc() {
        s = new StackInt();
    }

    public final void compile(char[] str) {
        super.compile(str);
        
        System.out.println("" + ret(s.top()));
        N = false;
    }
    
    protected String ret(int n)
    {
    	String a = Integer.toString(n), b= "";
    	char[] mas = a.toCharArray();
    	int v = mas.length, mas2[];
    	mas2 = new int[v];
    	for (int i = 0, s = v-1; i < v; i++, s--) {
    		mas2[s] = char2int(mas[i]);
    	}
    	
    	for (int i = v - 1; i >= 0; i--) {
    		switch (i) {
    		case 3:
    			for (int t = 1; t <= mas2[i]; t++) b += "M";
    			break;
    		case 2:
    			if (mas2[i] == 9) {
    				b += "CM";
    				break;
    			}
    			if (mas2[i] == 5) {
    				b += "CD";
    				break;
    			}
    			int ost;
    			if (mas2[i] > 5) {
    				b += "D";
    				ost = mas2[i] % 5;
    			}
    			else ost = mas2[i];
    			for (int t = 1; t <= ost; t++) b += "C";
    			break;
    		case 1:
    			if (mas2[i] == 9) {
    				b += "XC";
    				break;
    			}
    			if (mas2[i] == 5) {
    				b += "XL";
    				break;
    			}
    			int ost1;
    			if (mas2[i] >= 5) {
    				b += "L";
    				ost1 = mas2[i] % 5;
    			}
    			else  ost1 = mas2[i];
    			for (int t = 1; t <= ost1; t++) b += "X";
    			break;
    		case 0:
    			if (mas2[i] == 9) {
    				b += "IX";
    				break;
    			}
    			if (mas2[i] == 5) {
    				b += "IV";
    				break;
    			}
    			int ost2;
    			if (mas2[i] >= 5) {
    				b += "V";
    				ost2 = mas2[i] % 5;
    			}
    			else  ost2 = mas2[i];
    			for (int t = 1; t <= ost2; t++) b += "I";
    			break;
    		}
    }
    	return b;
    }
}