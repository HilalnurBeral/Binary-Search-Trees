//-----------------------------------------------------
// Title: BST
// Author: Hilalnur Beral 
// Section: 01
// Assignment: 4
// Description: This class defines a moviedatabase with binary search tree. 
//-------------


import java.util.ArrayList;

public class MovieDatabase  {

	// BST node
	static class Node {
		
		String movieTit;
		String directorLast;
		String directorFirst;
		int releaseD;
		int releaseM;
		int releaseY;
		static Node root;

		Node left, right;
	}

	static class ActorNode{
		String ActorFirst;
		String ActorLast;
		String roleTit;
		String movie;
		ActorNode leftA,rightA;
		static ActorNode root2;
	}
	
	Node movieTreeNode;
	ActorNode actorTreeNode;
	 Node mroot; 
	 ActorNode acroot;
	  
	    // Constructor 
	  MovieDatabase() 
	    { 
	        mroot = null; 
	        acroot = null;
	    } 


	

	// Utitlity function to create a new node
	static Node newNode(String movieTitle, String directorFirstName, String directorLastName, int releaseDay,
			int releaseMonth, int releaseYear) {
		
		//--------------------------------------------------------
		 // Summary: Created a new node for the movie binary search tree.
		 // Precondition: miveTitle is string,directorFirstName is string, directorLastName is string, releaseday is int
		//releaseMonth is integer and release year is an integer.
		 // Postcondition: Attributes are added for the specific movie node.
		 //--------------------------------------------------------
		
		
		Node temp = new Node();

		temp.movieTit = movieTitle;
		temp.directorFirst = directorFirstName;
		temp.directorLast = directorLastName;
		temp.releaseD = releaseDay;
		temp.releaseM = releaseMonth;
		temp.releaseY = releaseYear;

		temp.left = null;
		temp.right = null;

		return temp;
	}

	static ActorNode newActor(String movieTitle, String ActorFirstName, String ActorLastName, String roleTitle) {
		//--------------------------------------------------------
		 // Summary: Created a new node for the Actor binary search tree.		 // name is given.
		 // Precondition: movieTitle is string, ActorFirstName is string and roleTitle is string.		 // integer
		 // Postcondition: For actor BST , new node is created and attributed are added for specific actor node.
		 //--------------------------------------------------------
		ActorNode node = new ActorNode();
		node.movie=movieTitle;
		node.ActorFirst=ActorFirstName;
		node.ActorLast= ActorLastName;
		node.roleTit=roleTitle;
		node.leftA=null;
		node.rightA=null;
		return node ;
	}
	
	public void showAllMovies() {
		//--------------------------------------------------------
		 // Summary: It calls showAllMoviesU(Node root) function		 // name is given.
		 // Precondition:No parameter is needed		 // integer
		 // Postcondition: All movies can be printed succesfully .
		 //--------------------------------------------------------
		if (mroot == null) {
			System.out.println("---none---");
			return;
		}
		showAllMoviesU(mroot);		
	}
	

public void showAllMoviesU(Node root) {
		//--------------------------------------------------------
		 // Summary: This method is created in order to show all movies in BST. 
	     // This is helper function for showAllMovies()
		 // Precondition: root is node type.		 // integer
		 // Postcondition: All movies which are in BST printed succesfully..
		 //--------------------------------------------------------
		if (root == null)
			return;
		else {
			showAllMoviesU(root.right);
			System.out.print(root.movieTit+", ");
			System.out.print(root.releaseY + ", ");
			System.out.print(root.directorFirst + " ");
			System.out.println(root.directorLast + " ");
			showAllMoviesU(root.left);

		}
	}
	void showAllActors() {
		//--------------------------------------------------------
		 // Summary: This method calls the showAllActorsU(ActorNode root) method in order to print the actors.
		 // Precondition: No parameter is needed		 // integer
		 // Postcondition: All actors are printed succesfully.
		 //--------------------------------------------------------
		showAllActorsU(acroot);		
	}
	
	static void showAllActorsU(ActorNode root) {
		//--------------------------------------------------------
		 // Summary: This method is created in order to show all actors in BST.	
		// This is helper function.
		 // Precondition: root is type of ActorNode		 // integer
		 // Postcondition: All actors whic are added BST can be printed successfully.
		 //--------------------------------------------------------
		if (root == null)
			return;
		else {
			showAllActorsU(root.rightA);
			System.out.print(root.movie + " ");
			System.out.print(root.ActorFirst + " ");
			System.out.println(root.ActorLast + " ");
			showAllActorsU(root.leftA);
		}
	}
	public void addMovie(String movieTitle, String directorFirstName, String directorLastName,
			int releaseDay, int releaseMonth, int releaseYear) {
		
//--------------------------------------------------------
 // Summary: This method calls the addMovieU( (Node root, String movieTitle, String directorFirstName, String directorLastName,int releaseDay, int releaseMonth, int releaseYear)	
// Precondition: movieTitle is string, directorFirstName is string, directorLastName is string,
		//releaseDay is int,releaseMonth is int and releaseYear is int.
// Postcondition: Movies can be added successfully to the movie BST.
//--------------------------------------------------------
		
		mroot = addMovieU(mroot,  movieTitle,  directorFirstName,  directorLastName,
				 releaseDay,  releaseMonth,  releaseYear);
	}
	
	static Node addMovieU(Node root, String movieTitle, String directorFirstName, String directorLastName,
			int releaseDay, int releaseMonth, int releaseYear) { /* If the tree is empty, return a new node */
		//--------------------------------------------------------
		 // Summary: This method is created in order to add new movie to the BST.	
		// This is helper function for addMovie(String movieTitle, String directorFirstName, String directorLastName ,int releaseDay, int releaseMonth, int releaseYear) 
		 // Precondition: root is type of Node, movieTitle is string, directorFirstName is string, directorLastName is string,
		//releaseDay is int,releaseMonth is int and releaseYear is int.
		 // Postcondition: Movies are added to BST successfully.
		 //--------------------------------------------------------
		if (root == null) 
        { 
            root = newNode(movieTitle,directorFirstName,directorLastName,releaseDay,releaseMonth,releaseYear); 
    		System.out.println("INFO: " + movieTitle +" has been added.");
            return root; 
        }   
        
        if(movieTitle == root.movieTit) {
        	System.out.println("ERROR: Movie "+movieTitle+" already exists");
        }   
        if (releaseYear <= root.releaseY && !(movieTitle.equalsIgnoreCase(root.movieTit))) 
            root.left = addMovieU(root.left, movieTitle,directorFirstName,directorLastName,releaseDay,releaseMonth,releaseYear); 
        else if (releaseYear >= root.releaseY && !(movieTitle.equalsIgnoreCase(root.movieTit))) 
            root.right = addMovieU(root.right, movieTitle,directorFirstName,directorLastName,releaseDay,releaseMonth,releaseYear); 
     
        return root;
        }
	
	public void addActor(String movieTitle, String ActorFirstName, String ActorLastName,
			String roleTit) {
		
		//--------------------------------------------------------
		 // Summary: This method calls the addActorU( ActorNode root, String movieTitle, String ActorFirstName, String ActorLastName, String roleTit)	
		// Precondition: movieTitle is string, ActorFirstName is string, ActorLastName is string,
				//roleTit is string
		// Postcondition: Actors can be added successfully to the Actor BST.
		//--------------------------------------------------------
		
		acroot = addActorU(acroot,  movieTitle,  ActorFirstName,  ActorLastName,
				roleTit);
	}	 
	
	public ActorNode addActorU(ActorNode root, String movieTitle, String ActorFirstName, String ActorLastName, String roleTit) {
		
		//VERY IMPORTANT NOTE: WE USED ARRAYLIST ONLY FOR NAVIGATE THE TREE,WE USED BST IN ALL FUNCTIONS AS REQUESTED.
		
		//--------------------------------------------------------
		 // Summary: This method is created in order to add new actor to the BST.	
		// This is helper function for addActor(String movieTitle, String ActorFirstName, String ActorLastName,String roleTit) 
		 // Precondition: root is type of ActorNode, movieTitle is string, ActorFirstName is string, ActorLastName is string,
		//roleTit is string.
		 // Postcondition: Actors are added to BST successfully.
		 //--------------------------------------------------------
			ArrayList<Node> movieList = new ArrayList<Node>();
		    ArrayList<ActorNode> aList = new ArrayList<ActorNode>();
		 	int count=0;
		 	int cast= 0;
		    treeTravelMovie(mroot,movieList);
		    for(int i =0;i<movieList.size();i++) {
		    	if(movieTitle.equalsIgnoreCase(movieList.get(i).movieTit)) {
		    		count++;
		    	}
		    }
		    if(count == 0) {
		    	System.out.println(movieTitle +" does not exist");
		    }
		    if (root == null) 
	        { 
	            root = newActor(movieTitle,ActorFirstName,ActorLastName,roleTit); 
	            return root; 
	        } 
		    for(int j = 0; j < aList.size(); j++) {
		    	if(aList.get(j).movie.equalsIgnoreCase(movieTitle)&&aList.get(j).ActorFirst.equalsIgnoreCase(ActorFirstName)&&aList.get(j).ActorLast.equalsIgnoreCase(ActorLastName)){
		    		cast++; 
		    	}
		    }  
		    if(cast> 0) {
		    	System.out.println(ActorFirstName+" "+ActorLastName+" already exist in the cast of "+ movieTitle);
		    }
	        /* Otherwise, recur down the tree */
	        if (ActorFirstName.compareToIgnoreCase(root.ActorFirst)<=0 && count !=0 && cast<=0 ) 
	            root.leftA = addActorU(root.leftA,movieTitle,ActorFirstName,ActorLastName,roleTit  ); 
	        else if (ActorFirstName.compareToIgnoreCase(root.ActorFirst)>=0 && count !=0 && cast<=0) 
	            root.rightA = addActorU(root.rightA,movieTitle,ActorFirstName,ActorLastName,roleTit); 
	
	        /* return the (unchanged) node pointer */
	        return root;
			
	}



	void removeMovie(String MovieTitle) 
    { 
        mroot = deleteRec(mroot, MovieTitle);
    } 
      /* A recursive function to insert a new key in BST */
    Node deleteRec(Node root, String movieTitle) 
    { 
    	
    	//--------------------------------------------------------
		 // Summary: This method deletes the movie from BST
		// Precondition: root is type of root and movieTitle is string.
    	//This is helper function for removeMovie(String MOvieTitle) function.
		// Postcondition:movie node is deleted successfully from BST.
		//--------------------------------------------------------
    	
    	int releaseYearnew=0;
    	int kontrol=0;
    	ArrayList<Node> movieTree = new ArrayList<Node>();
    	treeTravelMovie(mroot,movieTree);
    	for(int i=0;i<movieTree.size();i++){
    		if(movieTree.get(i).movieTit.equalsIgnoreCase(movieTitle)) {
        		releaseYearnew=movieTree.get(i).releaseY;
        		kontrol++;
    		}
    	}
    	if(kontrol==0) {
    		System.out.println("This movie does not exist in the database.");
    	}
        if (root == null)  return root; 
  
        if (releaseYearnew<root.releaseY && kontrol !=0) 
            root.left = deleteRec(root.left, movieTitle); 
        else if (releaseYearnew>root.releaseY && kontrol !=0) 
            root.right = deleteRec(root.right, movieTitle); 
  
      
        else if(kontrol > 0)
        { 
            System.out.println("INFO: movie "+movieTitle+" has been removed" );
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
           
            root.releaseY = minValue(root.right); 
  
            root.right = deleteRec(root.right, root.movieTit); 
        } 

        return root; 
    } 
   int minValue(Node root) 
    { 
       int minv = root.releaseY; 
        while (root.left != null) 
        { 
            minv = root.left.releaseY; 
            root = root.left; 
        } 
        return minv; 
    } 
	

    public static void treeTravelMovie(Node node,ArrayList<Node> movieTree) {
        if (node != null) {
            treeTravelMovie(node.left,movieTree);
            movieTree.add(node);
            treeTravelMovie(node.right,movieTree);
        }
    }
  
    public static void treeTravelActor(ActorNode node,ArrayList<ActorNode> actorTree) {
        if (node != null) {
            treeTravelActor(node.leftA,actorTree);
            actorTree.add(node);
            treeTravelActor(node.rightA,actorTree);
        }
    }
    
    public void showMovie(String movieTitle) {
	  	//--------------------------------------------------------
		 // Summary: This method calls detailedInfo(ActorNode tree1, Node tree2, String movieTitle) function.
		// Precondition:movieTitle is string
		// Postcondition:Informations are showed successfully.
		//--------------------------------------------------------
    	
    	
    	detailedInfo(acroot,mroot,movieTitle);
    }
    
	 static void detailedInfo(ActorNode tree1, Node tree2, String movieTitle){
		 
		 
		 
//VERY IMPORTANT NOTE: We used arraylist only for the NAVIGATE the our tree. 
//We used Binary search tree in all functions as requested!!!
		 
		  	//--------------------------------------------------------
			// Summary: This method show the information about a specific movie
			// Precondition: tree1 is type of ActorNode , tree2 is type of Node and movieTitle is string.
		    //This is helper function for showMovie(String MOvieTitle) function.
			// Postcondition:Informations are showed successfully.
			//--------------------------------------------------------
		    
		    ArrayList<Node> movieTree = new ArrayList<Node>();
		    ArrayList<ActorNode> actorTree = new ArrayList<ActorNode>();
		    int kontrol=0;
		 	int count=0;
		    treeTravelMovie(tree2,movieTree);
		    treeTravelActor(tree1,actorTree);
		   for(int i = 0; i<movieTree.size(); i++) {
			   for(int j = 0; j<actorTree.size(); j++) {
				   if(movieTree.get(i).movieTit == movieTitle && actorTree.get(j).movie == movieTitle ) {
					   kontrol++;
					   if (count == 0){		   
						   System.out.println(movieTree.get(i).movieTit);
						   System.out.println(movieTree.get(i).releaseD+ "/"+movieTree.get(i).releaseM+"/"+movieTree.get(i).releaseY);
						   System.out.println(movieTree.get(i).directorFirst+" "+movieTree.get(i).directorLast);
						   System.out.println(actorTree.get(j).ActorFirst+" "+actorTree.get(j).ActorLast+","+actorTree.get(j).roleTit);	 
					   }
					   else {
						   System.out.println(actorTree.get(j).ActorFirst+" "+actorTree.get(j).ActorLast+","+actorTree.get(j).roleTit);						 
					   }
					   count++;
				   }
			   }
		   	}
		   if(kontrol==0) {
			   System.out.println("---none---");
		   }
	 }
	 
	 public void showActorRoles(String aName, String aSurname) {
		//--------------------------------------------------------
		// Summary: This method show the information about the actor roles.It calls  showActorRolesU(acroot,mroot,aName,aSurname) function.
		// Precondition:  aName is string and aSurname is string.		
		// Postcondition:Actor roles are showed successfully.
		 showActorRolesU(acroot,mroot,aName,aSurname);
	    }
	
	 static void showActorRolesU(ActorNode tree1, Node tree2, String aName, String aSurname){
		 
		//VERY IMPORTANT NOTE: We used arraylist only for the NAVIGATE the our tree. 
		//We used Binary search tree in all functions as requested!!!
		 
		 
		//--------------------------------------------------------
		// Summary: This method show the information about the actor roles
		// Precondition: tree1 is type of ActorNode , tree2 is type of Node, aName is string and aSurname is string.
		//This is helper function for showActorRoles(String aName,String aSurname) function.
		// Postcondition:Actor roles are showed successfully.
		//--------------------------------------------------------
		 	int kontrol=0;
		 	int count =0;
		 	ArrayList<Node> movieTree = new ArrayList<Node>();
		    ArrayList<ActorNode> actorTree = new ArrayList<ActorNode>();
		    treeTravelMovie(tree2,movieTree);
		    treeTravelActor(tree1,actorTree);
		    for(int i = 0; i<actorTree.size();i++) {
		    	if(actorTree.get(i).ActorFirst == aName && actorTree.get(i).ActorLast==aSurname) {
		    		kontrol++;
		    		if(count==0){
		    			System.out.println(actorTree.get(i).ActorFirst+" "+actorTree.get(i).ActorLast);
		    			System.out.print(actorTree.get(i).roleTit+" "+actorTree.get(i).movie+" ");
			    		for(int j =0; j<movieTree.size();++j) {
			    			if(movieTree.get(j).movieTit == actorTree.get(i).movie) {
			    				System.out.println(movieTree.get(j).releaseY);
			    			}
			    		}
		    			
		    		}
		    		
		    		else{
		    			System.out.print(actorTree.get(i).roleTit+" "+actorTree.get(i).movie+" ");
			    		for(int j =0; j<movieTree.size();++j) {
			    			if(movieTree.get(j).movieTit == actorTree.get(i).movie) {
			    				System.out.println(movieTree.get(j).releaseY);
			    			}
			    		}
		    			
		    		}
		    		
		    		count++;	
		   	}
		    	
	    }
		    if(kontrol==0) {
		    	System.out.println("---none---");
		    }
		    
	 }
	 
	 public void showDirectorMovies(String DirectorName, String DirectorLast1) {
		//--------------------------------------------------------
		// Summary: This method show the movies  which were directed by a particular director.
		 //It calls DirectorMoviesU(Node tree2, String DirectorName,String DirectorLast1) function
		// Precondition: DirectorName is string and DirectorLast1 is string.		
		// Postcondition:Movies which are directed by particular director are printed succesfully.
		//--------------------------------------------------------
		 DirectorMoviesU(mroot,DirectorName,DirectorLast1);
	    }
	
	 public void DirectorMoviesU(Node tree2, String DirectorName,String DirectorLast1){
		 
		//VERY IMPORTANT NOTE: We used arraylist only for the NAVIGATE the our tree. 
		//We used Binary search tree in all functions as requested!!!
		 
		 
		//--------------------------------------------------------
		// Summary: This method show the movies  which were directed by a particular director.
		// Precondition: tree2 is type of Node, DirectorName is string and DirectorLast1 is string.
		//This is helper function for showDirectorMovies(String DirectorName, String DirectorLast1) function.
		// Postcondition:Movies which are directed by particular director are printed succesfully.
		//--------------------------------------------------------
		 int kontrol=0;
		 int count =0;
		 ArrayList<Node> movieTree = new ArrayList<Node>();
		 treeTravelMovie(tree2,movieTree);
		  
			   for(int j = movieTree.size()-1; j>=0; j--) {
				   if(movieTree.get(j).directorFirst.equalsIgnoreCase(DirectorName) && movieTree.get(j).directorLast.equalsIgnoreCase(DirectorLast1)) {
					  kontrol++;
					   if (count==0){
						   
						   System.out.println(movieTree.get(j).directorFirst+" "+movieTree.get(j).directorLast);
						   System.out.println(movieTree.get(j).movieTit+ ","+movieTree.get(j).releaseD+"/"+movieTree.get(j).releaseM+"/"+movieTree.get(j).releaseY);
						     
					   }
					   else{
						   System.out.println(movieTree.get(j).movieTit+ ","+movieTree.get(j).releaseD+"/"+movieTree.get(j).releaseM+"/"+movieTree.get(j).releaseY);			   
						   
					   }			   			   
					   count++;				   
				   }
			   }
			   if(kontrol==0) {
				   System.out.println("---none---");
			   }
	 		}
	 
	 public void showMovies(int Year) {
		 
		//--------------------------------------------------------
		// Summary: This method show the movies  which were released in particular year.
		//This function calls the showMoviesU(Node tree2,int Year) function.
		// Precondition: Year is int..
		// Postcondition:Movies which are released in particular year are printed succesfully.
		//-------------------------------------------------------- 
		 
		 showMoviesU(mroot,Year);
	    }
	 
	 public void showMoviesU(Node tree2,int Year){
		 
		//VERY IMPORTANT NOTE: We used arraylist only for the NAVIGATE the our tree. 
		//We used Binary search tree in all functions as requested!!! 
		 
		//--------------------------------------------------------
		// Summary: This method show the movies  which were released in particular year..
		// Precondition: tree2 is type of Node, Year is int..
		//This is helper function for showMovies(int Year) function.
		// Postcondition:Movies which are released in particular year are printed succesfully.
		//-------------------------------------------------------- 
		 int kontrol=0;
		 int count =0;
		 ArrayList<Node> movieTree = new ArrayList<Node>();
		 treeTravelMovie(tree2,movieTree);
		  
			   for(int j = 0; j<movieTree.size(); j++) {
				   if(movieTree.get(j).releaseY==Year ) {
					  kontrol++;
					   if (count==0){
						   
						System.out.println(movieTree.get(j).releaseY);
						System.out.println(movieTree.get(j).movieTit+ ","+movieTree.get(j).directorFirst+" "+movieTree.get(j).directorLast+" "+ movieTree.get(j).releaseD+"/"+movieTree.get(j).releaseM+"/"+movieTree.get(j).releaseY);
						     
					   }
					   else{
						   System.out.println(movieTree.get(j).movieTit+ ","+movieTree.get(j).directorFirst+" "+movieTree.get(j).directorLast+" "+movieTree.get(j).releaseD+"/"+movieTree.get(j).releaseM+"/"+movieTree.get(j).releaseY);					   
					   }		   
					   count++;
					   
				   }  
			   }
			   if(kontrol==0) {
				   System.out.println("---none---");
			   }
	 }
	 
	 public void showMovies(int Year,int Year2) {
		//--------------------------------------------------------
		// Summary: This method show the movies  which were released between two years
		// Precondition: tYear is int and Year2 is int.
		//This function calls the showMoviesM(Node tree2,int Year,int Year2) function.
		// Postcondition:Movies which are released between two years are printed succesfully.
		//-------------------------------------------------------- 
			 
		 
		 
		 showMoviesM(mroot,Year,Year2);
	    }
	 
	 
	 public void showMoviesM(Node tree2,int Year,int Year2){
		 
		//VERY IMPORTANT NOTE: We used arraylist only for the NAVIGATE the our tree. 
		//We used Binary search tree in all functions as requested!!!
		 
		 
		 
		//--------------------------------------------------------
		// Summary: This method show the movies  which were released between two years
		// Precondition: tree2 is type of Node, Year is int and Year2 is int.
		//This is helper function for showMovies(int Year,int Year2) function.
		// Postcondition:Movies which are released between two years are printed succesfully.
		//--------------------------------------------------------
		 
		 int kontrol =0;
		 int count =0;
		 ArrayList<Node> movieTree = new ArrayList<Node>();
		    treeTravelMovie(tree2,movieTree);	  
			   for(int j = movieTree.size()-1; j>=0; j--) {
				   if(((movieTree.get(j).releaseY<=Year)&& movieTree.get(j).releaseY>=Year2)||(movieTree.get(j).releaseY>=Year)&& movieTree.get(j).releaseY<=Year2) {
					  kontrol++;
					   if (count==0){
						   
						if(Year<=Year2){
							System.out.println("Released between "+Year+"-"+Year2);
							System.out.println(movieTree.get(j).movieTit+","+movieTree.get(j).directorFirst+" "+movieTree.get(j).directorLast+","+movieTree.get(j).releaseY);
						}
						else if(Year2>=Year){
							
							System.out.println("Released between "+Year2+"-"+Year);
							System.out.println(movieTree.get(j).movieTit+","+movieTree.get(j).directorFirst+" "+movieTree.get(j).directorLast+","+movieTree.get(j).releaseY);
							
						}
						else{
							System.out.println("Wrong!!");
						}
						  
						     
					   }
					   else{
						   System.out.println(movieTree.get(j).movieTit+","+movieTree.get(j).directorFirst+" "+movieTree.get(j).directorLast+","+movieTree.get(j).releaseY);
						   
						   
					   }

					   count++;
					   
				   }  
		   }
			   if(kontrol==0) {
				   System.out.println("---none---");
			   }
	 }


	 void removeActor(String movieTitle, String actorFirstName,
			 String actorLastName) 
    { 
//--------------------------------------------------------
// Summary: This method deletes an actor from actor BST.
//This function calls the deleteActor(ActorNode root,String movieTitle, String actorFirstName,String actorLastName) 
// Precondition:movieTitle is string,actorFirstName is string and ActorLastname is string.
// Postcondition:Actors are deleted succesfully.
//-------------------------------------------------------- 
		 
        acroot = deleteActor(acroot, movieTitle,actorFirstName,actorLastName); 
    } 
      /* A recursive function to insert a new key in BST */
    ActorNode deleteActor(ActorNode root,String movieTitle, String actorFirstName,
			 String actorLastName) 
    { 
    //--------------------------------------------------------
    // Summary: This method deletes an actor from actor BST.
    // Precondition: root is type of ActorNode,movieTitle is string,actorFirstName is string and ActorLastname is string.
    //This is helper function for removeActor(String movieTitle, String actorFirstName, String actorLastName)  function.
    // Postcondition:Actors are deleted succesfully.
    //-------------------------------------------------------- 
    	 ArrayList<Node> movieTree = new ArrayList<Node>();
    	 treeTravelMovie(mroot,movieTree);
    	 ArrayList<ActorNode> aList = new ArrayList<ActorNode>();
    	 int kontrol=0;
    	 treeTravelActor(root,aList);
    	 for(int i=0; i<movieTree.size();i++) {
    		 for(int j=0;j<aList.size();j++) {
    			 if(movieTree.get(i).movieTit.equalsIgnoreCase(movieTitle)&&aList.get(j).movie.equalsIgnoreCase(movieTitle)&&aList.get(j).ActorFirst.equalsIgnoreCase(actorFirstName)&&aList.get(j).ActorLast.equalsIgnoreCase(actorLastName)){
    				 kontrol++;
    			 }
    		 }
    	 }
    	 if(kontrol == 0) {
    		 System.out.println("Movie or actor does not exist in the system.");
    	 }
    	
        if (root == null) {
        	return root; 
        }
  
        if (actorFirstName.compareTo(root.ActorFirst)<0 && kontrol != 0 ) 
            root.leftA = deleteActor(root.leftA, movieTitle, actorFirstName, actorLastName); 
        else if (actorFirstName.compareTo(root.ActorFirst)>0 && kontrol != 0 ) 
            root.rightA = deleteActor(root.rightA, movieTitle, actorFirstName, actorLastName); 
 
        else if(kontrol > 0)
        { 
        	System.out.println("INFO: "+actorFirstName+" "+actorLastName+" has been removed from the movie "+movieTitle);
            System.out.println();
            if (root.leftA == null) 
                return root.rightA; 
            else if (root.rightA == null) 
                return root.leftA; 
  
            root.ActorFirst = minValueActor(root.rightA); 
            root.rightA = deleteActor(root.rightA, root.movie, root.ActorFirst,root.ActorLast); 
        }
  
        return root; 
    } 
   String minValueActor(ActorNode root) 
    { 
       String minv = root.ActorFirst; 
        while (root.leftA != null) 
        { 
            minv = root.leftA.ActorFirst; 
            root = root.leftA; 
        } 
        return minv; 
    }
	

}
