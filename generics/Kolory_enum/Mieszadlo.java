public enum Mieszadlo {
        ADD {
            @Override
            public Kolor mieszaj(Kolor a, Kolor b) {
            	double x,y,z;
            	if((a.r + b.r) <= 1){
            		 x = a.r + b.r;}
            	else{
            		x = 1;}
            	if((a.g + b.g) <= 1){
            		y = a.g + b.g;}
            	else{
            		y = 1;}
            	if((a.b + b.b) <= 1){
            		z = a.b + b.b;}
            	else{
            		z = 1;}
 
                System.out.println(a +" 'ADD' "+ b +" = "+ Kolor.nazwij(x,y,z));
 
                return Kolor.nazwij(x,y,z);
            }

        }
        ,MUL {
            @Override
            public Kolor mieszaj(Kolor a, Kolor b) {
            	double x,y,z;
            	if((a.r * b.r) <= 1){
            		 x = a.r * b.r;}
            	else{
            		x = 1;}
            	if((a.g * b.g) <= 1){
            		y = a.g * b.g;}
            	else{
            		y = 1;}
            	if((a.b * b.b) <= 1){
            		z = a.b * b.b;}
            	else{
            		z = 1;}
 
                System.out.println(a +" 'MUL' "+ b +" = "+ Kolor.nazwij(x,y,z));
 
                return Kolor.nazwij(x,y,z);
            }
        },
        AVER {
            @Override
            public Kolor mieszaj(Kolor a, Kolor b) {
            double x,y,z;
        	if(((a.r + b.r)/2) <= 1){
        		 x = (a.r + b.r)/2;}
        	else{
        		x = 1;}
        	if(((a.g + b.g)/2) <= 1){
        		y = (a.g + b.g)/2;}
        	else{
        		y = 1;}
        	if(((a.b + b.b)/2) <= 1){
        		z = (a.b + b.b)/2;}
        	else{
        		z = 1;}
 
                System.out.println(a +" 'AVER' "+ b +" = "+ Kolor.nazwij(x,y,z));
 
                return Kolor.nazwij(x,y,z);
            }
        };
 
        public abstract Kolor mieszaj(Kolor a, Kolor b);
 
    }
