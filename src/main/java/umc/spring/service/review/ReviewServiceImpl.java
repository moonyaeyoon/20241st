package umc.spring.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.dto.request.ReviewRequestDTO;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.repository.UserRepository;

import static umc.spring.dto.converter.ReviewConverter.toReview;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService{
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public void createReview(Long userId, Long storeId, ReviewRequestDTO.CreateReviewDTO createReviewDTO){
        User user = findUserById(userId);
        Store store = findStoreById(storeId);
        Review review = toReview(createReviewDTO);
        review.setUser(user);
        review.setStore(store);
        reviewRepository.save(review);

    }

    private User findUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
    }

    private Store findStoreById(Long storeId){
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("가게를 찾을 수 없습니다."));
    }
}
