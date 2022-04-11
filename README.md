# Documentation

Final Activity 1: Temperature.

## Groupmates

Colston Bod-oy - Coding  
Jean Delmari Bernal - Documentation

## Output

![Screenshot_1](https://user-images.githubusercontent.com/75562733/162757953-17fa7547-605e-4df9-86ed-2c80ad9b6c02.png)
![Screenshot_2](https://user-images.githubusercontent.com/75562733/162757986-f6986a91-5a4e-4801-b29b-4acd50c9af09.png)
![Screenshot_3](https://user-images.githubusercontent.com/75562733/162758020-b09b56de-cc57-4970-bfbc-07eb3789ca64.png)

* Contains 1 main class named TempConverter that extends the class JFrame, implements ActionListener and FocusListener.
```
Whole project with assets: https://github.com/ColstonBod-oy/temp-converter
```

### TempConverter.java

![Screenshot_4](https://user-images.githubusercontent.com/75562733/162759571-40add9eb-b9fb-4d2a-9622-7d1d241701b5.png)

* Creates 2 JTextFields and assigns their values to celsiusText and fahrenheitText then adds a FocusListener to them.
* Creates 1 JButton named convert then adds an ActionListener to it.
* Creates 2 JLabels named celsiusLabel and fahrenheitLabel.  
* Creates a JPanel named celsiusPanel that uses a FlowLayout to add the celsiusLabel and celsiusText next to each other.  
* Creates a JPanel named fahrenheitPanel that uses a FlowLayout to add the fahrenheitLabel and fahrenheitText next to each other.
* Creates a JPanel named mainPanel that uses a GridBagLayout to add the celsiusPanel, fahrenheitPanel, and convert button on the center of the frame. 
```
@Override
public void focusGained(FocusEvent e) {
   if (e.getSource() == celsiusText) {
      fahrenheitText.setText("");
   }
        
   else if (e.getSource() == fahrenheitText) {
      celsiusText.setText("");
   }
}
```
Sets the text of the JTextField every time it was not focused to an empty string, so only 1 temperature unit would be converted. 
```
@Override
public void actionPerformed(ActionEvent e) {
   if (e.getSource() == convert) {
      if (!celsiusText.getText().equals("")) {
         fahrenheit = Double.toString(Double.parseDouble(celsiusText.getText()) * 1.8 + 32);
         fahrenheitText.setText(fahrenheit);
      }
            
      else if (!fahrenheitText.getText().equals("")) {
         celsius = Double.toString((Double.parseDouble(fahrenheitText.getText()) - 32) / 1.8);
         celsiusText.setText(celsius);
      }
   }
}
```
Every time the convert button was clicked, it converts the non-empty JTextField to the other temperature unit and sets the other JTextField's text to the result of the conversion. 

### End of Documentation
