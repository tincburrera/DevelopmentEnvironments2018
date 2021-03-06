// Adrián Navarro Gabino

import java.util.*;

public class VideoGameList3
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        VideoGame[] games = new VideoGame[5];
        
        for(int i = 0; i < 5; i++)
        {
            System.out.print("Enter the name of the game #" + (i + 1) +
                ": ");
            String newTitle = sc.nextLine();
            
            System.out.print("Enter the genre of the game #" + (i + 1) +
                ": ");
            String newGenre = sc.nextLine();
            
            System.out.print("Enter the price of the game #" + (i + 1) +
                ": ");
            double newPrice = sc.nextDouble();
            sc.nextLine();
            
            Company newCompany;
            
            System.out.print("Enter the name of the company: ");
            String newName = sc.nextLine();
            
            System.out.print("Enter the company year foundation: ");
            int newYear = sc.nextInt();
            sc.nextLine();
            
            newCompany = new Company(newName, newYear);
            
            games[i] = new VideoGame(newTitle, newGenre, newPrice,
                newCompany);
            
            System.out.println();
        }
        
        int cheapest = 0;
        int mostExpensive = 0;
        
        for(int i = 1; i < 5; i++)
        {
            if(games[i].getPrice() < games[cheapest].getPrice())
            {
                cheapest = i;
            }
            
            if(games[i].getPrice() > games[mostExpensive].getPrice())
            {
                mostExpensive = i;
            }
        }
        
        System.out.println("The cheapest game is: " +
            games[cheapest].getTitle());
        
        System.out.println("The most expensive game is: " +
            games[mostExpensive].getTitle());
            
        int mostRepeatedCompany = 0;
        int mostRepeatedCompanyCount = 0;
            
        for(int i = 0; i < 5; i++)
        {
            int companyCount = 1;
            for(int j = i + 1; j < 5; j++)
            {
                if(games[i].getCompany().getName().equalsIgnoreCase(
                    games[j].getCompany().getName()))
                {
                    companyCount++;
                }
            }
            
            if(companyCount > mostRepeatedCompanyCount)
            {
                mostRepeatedCompany = i;
            }
        }
        
        System.out.println("The most repeated company is: " +
            games[mostRepeatedCompany].getCompany().getName());
    }
}

class VideoGame
{
    protected String title;
    protected String genre;
    protected double price;
    protected Company company;
    protected static int numberOfCreatedVideoGames = 0;
    
    public void setTitle(String newTitle) { title = newTitle; }
    public void setGenre(String newGenre) { genre = newGenre; }
    public void setPrice(double newPrice) { price = newPrice; }
    public void setCompany(Company newCompany) { company = newCompany; }
    
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getPrice() { return price; }
    public Company getCompany() { return company; }
    
    public VideoGame(String title, String genre, double price,
        Company company)
    {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.company = company;
        this.numberOfCreatedVideoGames++;
    }
    public VideoGame()
    {
        this.numberOfCreatedVideoGames++;
    }
    
    @Override
    public String toString()
    {
        return "Title: " + this.title + "\nGenre: " + this.genre +
            "\nPrice: " + this.price + "\nCompany: " + this.company;
    }
    
    public static int numberOfCreatedVideoGames()
    {
        return numberOfCreatedVideoGames;
    }
}

class Company
{
    private String name;
    private int foundationYear;
    
    public Company(String newName, int newYear)
    {
        setName(newName);
        setFoundationYear(newYear);
    }
    
    public void setName(String newName) { name = newName; }
    public void setFoundationYear(int newYear)
    {
        foundationYear = newYear;
    }
    
    public String getName() { return name; }
    public int getFoundationYear() { return foundationYear; }
}

class PCVideoGame extends VideoGame
{
    protected int minimumRam;
    protected int minimumHD;
    
    public PCVideoGame(String title, String genre, double price,
        Company company, int minimumRam, int minimumHD)
    {
        super(title, genre, price, company);
        this.minimumRam = minimumRam;
        this.minimumHD = minimumHD;
    }
}
