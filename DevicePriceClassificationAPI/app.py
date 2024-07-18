from flask import Flask, request, jsonify
import pickle
import pandas as pd

app = Flask(__name__)

# Load the model and scaler
with open('device_price_classifier.pkl', 'rb') as model_file, open('scaler.pkl', 'rb') as scaler_file:
    model = pickle.load(model_file)
    scaler = pickle.load(scaler_file)

@app.route('/predict', methods=['POST'])
def predict():
    # Get JSON data from request
    data = request.get_json()
    df = pd.DataFrame(data)
    
    # Scale the data
    df_scaled = scaler.transform(df)
    
    # Make prediction
    predictions = model.predict(df_scaled)
    
    # Convert predictions to list
    predictions_list = predictions.tolist()
    
    return jsonify(predictions=predictions_list)

if __name__ == '__main__':
    app.run(debug=True)
