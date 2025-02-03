#include<stdio.h>

int main(){
    int dn,np=1,rem,i=0;
    char bn[100]; 
    printf("Enter a decimal Number: ");
    scanf("%d",&dn);
    while(dn!=0){
        rem=dn%4;
        bn[i]=rem+'0';
        dn=dn/2;
        i++;
    }
    bn[i]='\0';

    for (int j = i - 1; j>= 0; j--) {
        printf("%c", bn[j]);
    }
    
    return (0);
}
