/*
 * Shapes
 * Version 1.0.0
 * 20/07/21
 */
import javafx.application.Application; 
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.Label; 
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox; 
import javafx.scene.layout.VBox; 
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/*
 * Shapes is a simple application that presents 2D shapes depending on text input provided by the user.
 * Shapes also has a second function where the user can change the colour of a presented 2D shape through text input.
 * A larger variety of shapes/colours can easily be added to this program in the future.	
 */

public class Shapes extends Application 
{ 

    public void start(Stage stage)    
	{         
	    //shapeField and colourField are the main text fields for taking user inputs.         
	    TextField shapeField = new TextField();         
		shapeField.setMaxWidth(100);          
		
		TextField colourField = new TextField();         
		colourField.setMaxWidth(100);       
		
		
		//titleLabel presents the name of the program at the top of the scene.
		Label titleLabel = new Label("Shapes");         
		titleLabel.setTextFill(Color.ALICEBLUE);         
		titleLabel.setFont(Font.font("Comic Sans MS", 75));  
			
		
		//instuct1Label and instuct2Label provide instructions underneath the title.
		Label instruct1Label = new Label("Please type in the shape you would like to "
				                         + "see. Your options are circle, triangle or pentagon.");         
		instruct1Label.setTextFill(Color.ALICEBLUE);         
		instruct1Label.setFont(Font.font("Comic Sans MS", 25));
			
		Label instruct2Label = new Label("Then type in the colour you want your shape "
				                         + "painted in. Your options are red, blue or yellow. ");         
		instruct2Label.setTextFill(Color.ALICEBLUE);         
		instruct2Label.setFont(Font.font("Comic Sans MS", 25));  
			
		
		//shapeLabel and colourLabel act as user prompts to the left of their respective text fields.         
		Label shapeLabel = new Label("Enter shape:");         
		shapeLabel.setTextFill(Color.ALICEBLUE);         
		shapeLabel.setFont(Font.font("Comic Sans MS", 20));
			
		Label colourLabel = new Label("Enter colour:");         
		colourLabel.setTextFill(Color.ALICEBLUE);         
		colourLabel.setFont(Font.font("Comic Sans MS", 20));
			
		
		//shape acts as a starting "default" shape that is invisible to the user. This is replaced after user input.
	    Circle shape = new Circle(125, 125, 80);          
		shape.setFill(Color.DIMGREY);         
			 	 
		
		//triangle,pentagon and circle are the shapes the user can access. To start they are all presented in a "blank" colour.
		Polyline triangle = new Polyline ();   
		triangle.getPoints().addAll(100.0, 70.0, 100.0, 250.0, 400.0, 250.0);
	    triangle.setFill(Color.ALICEBLUE);         
			  		 
	    Polyline pentagon = new Polyline ();   
	    pentagon.getPoints().addAll(-200.0,-380.0,  -300.0,-300.0,   -270.0,-200.0, 
	    		                    -130.0,-200.0, -100.0,-300.0 );
	    pentagon.setFill(Color.ALICEBLUE);        
			 
	    Circle circle = new Circle(125, 125, 80);          
	    circle.setFill(Color.ALICEBLUE);         
			 

	    //showShapeButton and showColourLabel are buttons that action user input. Located to the right of their respective text fields.         
		Button showShapeButton = new Button();         
		showShapeButton.setText("Show shape");
			
		Button showColourButton = new Button();         
		showColourButton.setText("Show colour");   
			
		
		
		//This Hbox contains all the nodes related to inputing shape.                       
		HBox shapeInput = new HBox(10);
		shapeInput.setAlignment(Pos.CENTER);        
		shapeInput.getChildren().addAll(shapeLabel, shapeField, showShapeButton);  
		
		//This Hbox contains all the nodes related to inputing colour. 
		HBox colourInput = new HBox(10);
		colourInput.setAlignment(Pos.CENTER);        
		colourInput.getChildren().addAll(colourLabel, colourField, showColourButton);
						
		//This VBox is the root node for this scene.         
		VBox root = new VBox(25);
		root.setBackground(Background.EMPTY);
		root.setAlignment(Pos.CENTER);        
		root.getChildren().addAll(titleLabel,instruct1Label,instruct2Label,
				                  shapeInput, colourInput,shape); 
						
			
		//Below are the actions that process user input for shapes. 
		//This primarily focuses on first identifying what shape is requested. 
		//Secondly it removes any existing shape related node from the root node, replacing it with the correct one related to the input. 	
		showShapeButton.setOnAction( e -> {   
			
			
			//This feedbacks to the user if the text field is empty.
		    if(shapeField.getText().isEmpty()) {                               
			    JOptionPane.showMessageDialog(null,"No shape input! Choose: "
			    		                      + "circle, triangle or pentagon.",								              
			    		                      "ERROR", JOptionPane.WARNING_MESSAGE);                       
			} else { 
			    //Allows user to input any variation of case.
            	switch (shapeField.getText().toLowerCase()) {
            	
				    case "triangle":
					    if (root.getChildren().contains(shape)) {
						    root.getChildren().remove(shape);
							triangle.setFill(Color.ALICEBLUE);        
							root.getChildren().add(triangle);
						} else if(root.getChildren().contains(triangle)) {
						    root.getChildren().remove(triangle);
							triangle.setFill(Color.ALICEBLUE);       //This stops multiple creations of the same shape. 
							root.getChildren().add(triangle);
						} else if(root.getChildren().contains(circle)){
						    root.getChildren().remove(circle);
							triangle.setFill(Color.ALICEBLUE);        
							root.getChildren().add(triangle);
						} else if(root.getChildren().contains(pentagon)) {
					        root.getChildren().remove(pentagon);
							triangle.setFill(Color.ALICEBLUE);        
							root.getChildren().add(triangle);
						}
						break;

						
					case "circle":
						if (root.getChildren().contains(shape)) {
						    root.getChildren().remove(shape);
							circle.setFill(Color.ALICEBLUE);
							root.getChildren().add(circle);
						} else if(root.getChildren().contains(triangle)) {
							root.getChildren().remove(triangle);
							circle.setFill(Color.ALICEBLUE);
							root.getChildren().add(circle);
						} else if(root.getChildren().contains(circle)) {
							root.getChildren().remove(circle);
							circle.setFill(Color.ALICEBLUE);
							root.getChildren().add(circle);
						} else if(root.getChildren().contains(pentagon)) {
							root.getChildren().remove(pentagon);
							circle.setFill(Color.ALICEBLUE);
							root.getChildren().add(circle);
						}
						break;
	
						
					case "pentagon":
						if (root.getChildren().contains(shape)) {
							root.getChildren().remove(shape);
							pentagon.setFill(Color.ALICEBLUE);
							root.getChildren().add(pentagon);
						} else if(root.getChildren().contains(triangle)) {
							root.getChildren().remove(triangle);
							pentagon.setFill(Color.ALICEBLUE);
							root.getChildren().add(pentagon);
						} else if(root.getChildren().contains(circle)) {
							root.getChildren().remove(circle);
							pentagon.setFill(Color.ALICEBLUE);
							root.getChildren().add(pentagon);
						} else if(root.getChildren().contains(pentagon)) {
						    root.getChildren().remove(pentagon);
							pentagon.setFill(Color.ALICEBLUE);
						    root.getChildren().add(pentagon);
					    }
						break;
						
						//Ability to add more code here to accommodate the addition of new shapes. 
											 
					default: JOptionPane.showMessageDialog(null,"Unrecognized shape! Choose: "
							                               + "circle, triangle or pentagon.",
							                               "ERROR", JOptionPane.WARNING_MESSAGE);     
				}
			}
		});
					
			   
			   
		//Below are the actions that process user input for colour. 
	    //This primarily focuses on first identifying what colour is requested. 
		//Secondly it finds out from the root node what shape is currently being displayed and fills that particular shape accordingly. 	   
		showColourButton.setOnAction( e -> {
			
		    if(colourField.getText().isEmpty()) {                               
			    JOptionPane.showMessageDialog(null,"No colour input! Choose:"
			    		                      + " red, blue or yellow.",
				                              "ERROR", JOptionPane.WARNING_MESSAGE);                       
			} else { 
				
			    switch (colourField.getText().toLowerCase()) {
			    
				    case "red":
				        //This prompts the user to input a shape before inputing a colour.
				    	if (root.getChildren().contains(shape)) {
				            JOptionPane.showMessageDialog(null,"No shape to colour! Please enter "
				            		                      + "a shape before selecting a colour.",
					                                      "ERROR", JOptionPane.WARNING_MESSAGE);  
					    } else if(root.getChildren().contains(triangle)) {
				            triangle.setFill(Color.RED);
				        } else if(root.getChildren().contains(circle)) {
					        circle.setFill(Color.RED);
				        } else if(root.getChildren().contains(pentagon)) {
				            pentagon.setFill(Color.RED);
					    }
					    break;

					    
					case "blue":
					    if (root.getChildren().contains(shape)) {
					        JOptionPane.showMessageDialog(null,"No shape to colour! Please enter "
					        		                      + "a shape before selecting a colour.",
						                                  "ERROR", JOptionPane.WARNING_MESSAGE);  
						} else if(root.getChildren().contains(triangle)) {
					        triangle.setFill(Color.BLUE);
					    } else if(root.getChildren().contains(circle)) {
						    circle.setFill(Color.BLUE);
						} else if(root.getChildren().contains(pentagon)) {
					        pentagon.setFill(Color.BLUE);
						}
						break;
						    
					case "yellow":
					    if (root.getChildren().contains(shape)) {
					        JOptionPane.showMessageDialog(null,"No shape to colour! Please enter "
					        		                      + "a shape before selecting a colour.",
						                                  "ERROR", JOptionPane.WARNING_MESSAGE);  
						} else if(root.getChildren().contains(triangle)) {
					        triangle.setFill(Color.YELLOW);				        	
					    } else if(root.getChildren().contains(circle)) {
						    circle.setFill(Color.YELLOW);
						} else if(root.getChildren().contains(pentagon)) {
					        pentagon.setFill(Color.YELLOW);
						}
						break;
						
						//Ability to add more code here to accommodate the addition of new colours.
					    
				    default: JOptionPane.showMessageDialog(null,"Unrecognized colour! Choose: "
				    		                               + "red, blue or yellow.",
			                                               "ERROR", JOptionPane.WARNING_MESSAGE);     
			    }
			}
		});
									
									
		// The root node node is assigned to a newly created scene which is the subsequently assigned to a stage titled "Shapes".        
		Scene scene = new Scene(root, 1250, 750, Color.DIMGREY);         
		stage.setScene(scene);         
		stage.setTitle("Shapes");        
		stage.show(); 
			
    }					 
		
    public static void main(String[] args)     
	{         
			launch(args);     
	}
}