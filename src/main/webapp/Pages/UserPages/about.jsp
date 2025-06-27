<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Rules-Marshmallow Haven</title>

  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/b_logo.png" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/global_for_client.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/rules.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
  <!-- Header -->
    <c:set var="activePage" value="about" scope="request" />
<jsp:include page="/Pages/UserPages/Components/navbar.jsp"/>
  <!-- Main Content -->
         <section class="main-content">
          <div class="container">
            <h1 class="section-title">About Us</h1>
            
            <div class="rules-container">
              <div class="rule-section">
                <h2 class="rule-heading">Marshmallow Haven</h2>
                <p>
                  Welcome to Marshmallow Haven – a modern, secure, and student-focused hostel designed to make your academic life easier, safer, and more enjoyable.
                  Whether you're starting your university journey or continuing your studies, Marshmallow Haven is committed to providing a clean, well-managed, and peaceful environment that feels like home.
                </p>
              </div>

            
            
            
              <div class="rule-section">
                <h2 class="rule-heading">Who We Are</h2>
                <p>
                  Marshmallow Haven was established with a single goal: to offer students a safe and supportive living space that encourages both academic success and personal growth. 
                  Our hostel blends convenience, discipline, and comfort, creating the ideal setting for focused study and meaningful connections.
                </p>
              </div>

                  
            
              <div class="rule-section">
                <h2 class="rule-heading">What We Offer</h2>
                <p>
                Secure Living
                Your safety is our top priority. We have 24/7 security personnel, biometric access control, and CCTV cameras monitoring the premises round the clock to ensure you always feel protected.
                </p>
              </div>

              <div class="rule-section">
                <h2 class="rule-heading">Modern Facilitiesr</h2>
                <p>
                From high-speed internet and dedicated study rooms to fully equipped kitchens and spacious common areas, our amenities are designed to support both your academic and daily living needs.
                </p>
              </div>


            
              <div class="rule-section">
                <h2 class="rule-heading">Clean & Disciplined Environment</h2>
                <p>
                  Residents are expected to maintain cleanliness in their rooms and shared areas. Our clear hostel rules help maintain discipline, mutual respect, and order among residents.

                </p>
              </div>

        
              <div class="rule-section">
                <h2 class="rule-heading">Our Community Values</h2>
                <p>
                    We believe in:

                    Respect for All: Every resident is treated equally and with dignity. Ragging, bullying, and discrimination are strictly prohibited.

                    Responsibility: Cleanliness, punctuality, and adherence to hostel policies are part of our core expectations.

                    Transparency: All policies, fees, and rules are clearly outlined to avoid confusion and ensure a smooth stay.                       </p>
              </div>

          
              <div class="rule-section">
                <h2 class="rule-heading"> Rules That Protect You</h2>
                <p>
                  We strictly prohibit activities like smoking, alcohol use, drug possession, gambling, and unauthorized overnight stays. Our rules are not just regulations—they’re a framework to ensure peace, security, and fairness for everyone.          </p>
              </div>

          
              <div class="rule-section">
                <h2 class="rule-heading"> Rules That Protect You</h2>
                <p>
                  We strictly prohibit activities like smoking, alcohol use, drug possession, gambling, and unauthorized overnight stays. Our rules are not just regulations—they’re a framework to ensure peace, security, and fairness for everyone.          </p>
              </div>

            
              <div class="rule-section">
                <h2 class="rule-heading">Your Second Home</h2>
                <p> 
                  At Marshmallow Haven, we’re more than a place to stay—we’re a community that grows together. Whether you're studying late, cooking with friends, or relaxing in the lounge, you'll always feel supported, safe, and welcomed.

                  Marshmallow Haven – where comfort meets discipline, and where every student finds a second home.
                </p>        
              </div>

            </div>
            </div>
        </section>

  
  <!-- Footer -->
    <jsp:include page="/Pages/UserPages/Components/footer.jsp"/>
</body>
</html>