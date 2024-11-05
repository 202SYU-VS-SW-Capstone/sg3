import openai

# 여기가 지피티 키입력
openai.api_key = "dd"  

# 이미지 파일을 전송하고 분석 요청
def analyze_image(image_path, question="이미지에 있는 식재료가 무엇인지 알려줘"):
    with open(image_path, "rb") as image_file:
        response = openai.Image.create(
            model="gpt-4-turbo-vision",
            file=image_file,
            messages=[
                {"role": "system", "content": "You are a helpful assistant that can analyze images."},
                {"role": "user", "content": question}
            ]
        )
    # 어떤 결과 보여줄지
    return response['choices'][0]['message']['content']

# 이미지 경로쓰면됨
image_path = "C:\\Users\\mdk19\\Desktop\\capstone front\\Ai\\img\\test img2.jpg"  # 이미지 파일 경로
result = analyze_image(image_path)
print("분석 결과:", result)
