# Customer Service Chatbot

responses = {
    "hello": "Hello! How can I assist you today?",
    "hi": "Hi there! How can I help you?",
    "how are you": "I'm just a bot, but I'm functioning perfectly!",
    "name": "I am a simple customer service chatbot.",
    "help": "Sure! You can ask me basic questions.",
    "thanks": "You're welcome! Happy to help.",
    "bye": "Goodbye! Have a great day!"
}

print("====================================")
print(" CUSTOMER SERVICE CHATBOT ")
print("====================================")
print("Chatbot: Hello! Type 'bye' to exit.\n")

while True:

    user_input = input("You: ").lower().strip()

    if user_input == "bye":
        print("Chatbot:", responses["bye"])
        break

    found = False

    for key in responses:

        if key in user_input:
            print("Chatbot:", responses[key])
            found = True
            break

    if not found:
        print("Chatbot: Sorry, I didn't understand that. Please try again.")