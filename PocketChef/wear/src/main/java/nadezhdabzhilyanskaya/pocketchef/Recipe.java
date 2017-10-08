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
    public Recipe(String newName, String[] newIngredientsName,String[] newIngredientsAmount,ServingType[] newIngredientAmountType,String[] newSteps)
=======
    public Recipe(String newName, String[] newIngredientsName,String[] newIngredientsAmount,ServingType[] newIngredientAmountType,String[] newSteps,String newDescription, int newPrepTime,int newFullTime)
>>>>>>> 9a2e7fd62bbd091c0ebb6bd3a318c3c4178881af
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

    public String stepsToString()
    {
        String str = "";

        for (int i = 0; i < steps.length;i++)
        {
            str+= (i+1)+". "+steps[i] + "\n";
        }
        return str;
    }

    public String ingredentListToString()
    {
        String str = "";

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

    public String toString()
    {
        return (name +"\n\nIngredients:\n"+ingredentListToString()+"\n\nSteps:\n"+stepsToString());
    }
}
