def ADD(a, b):
    if a > b:
        return "la suma de (a) y (b):" + (a + b)
    else:
        return "no se pude sumar a es menor/igual que b: " +a+ "<="+ b

opc = True

print("|-----Bienvenido---------------------------------------------------------------------------|")
print("Este programa suma dos números con la condición de que el primero sea mayor que el segundo.")

while opc:  
    a = input("ingrese el primer numero: \n")
    b = input("ingrese el segundo numero: '\n")
    print(ADD(a,b))
    if input("¿Desea continuar? Presione cualquier tecla para seguir o N/n para salir: ") in ['N', 'n']:
        opc = False

exit()