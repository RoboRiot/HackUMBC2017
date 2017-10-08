package nadezhdabzhilyanskaya.pocketchef;

/**
 * Created by Dulia on 10/7/2017.
 */


public class Recipe
{
    public enum ServingType {
        TEASPOON, TABLESPOON, CUP, NONE
    }

    private String name;
    private String[] ingredientName;
    private String[] ingredientAmount;
    private ServingType[] ingredientAmountType;
    private String[] steps;
    private String description;
    private int prepTime;
    private int fullTime;
<<<<<<< HEAD


//    public Recipe(String newName, String[] newIngredientsName,String[] newIngredientsAmount,ServingType[] newIngredientAmountType,String[] newSteps)

=======
  
>>>>>>> 12e5a908c8325ee8054bf04953b12b648bcd3474
    public Recipe(String newName, String[] newIngredientsName,String[] newIngredientsAmount,ServingType[] newIngredientAmountType,String[] newSteps,String newDescription, int newPrepTime,int newFullTime)

    {
        name = newName;
        ingredientName = newIngredientsName;
        ingredientAmount = newIngredientsAmount;
        ingredientAmountType = newIngredientAmountType;
        steps = newSteps;
        description= newDescription;
        prepTime = newPrepTime;
        fullTime = newFullTime;
    }

    public String getName(){return name;}

    public String stepsToString(int step)
    {
        String str = ((step+1)+". "+steps[step] + "\n");
        return str;
    }

    public String ingredentListToString()
    {
        String str = "Ingridents: \n";

        for (int i = 0; i < ingredientName.length;i++)
        {
            str+= ingredientAmount[i] + " " + servingTypeToString(ingredientAmountType[i], ingredientAmount[i]) + " " + ingredientName[i] + "\n";
        }
        return str;
    }

    public String servingTypeToString(ServingType type, String amount)
    {
        if(amount.compareTo("1") == 0)
        {
            if (type == ServingType.TEASPOON) {return "teaspoon";}
            else if (type == ServingType.TABLESPOON) {return "tablespoon";}
            else if (type == ServingType.CUP) {return "cup";}
            else {return "";}
        }
        else {
            if (type == ServingType.TEASPOON) {return "teaspoons";}
            else if (type == ServingType.TABLESPOON) {return "tablespoons";}
            else if (type == ServingType.CUP) {return "cup";}
            else {return "";}
        }
    }
}
