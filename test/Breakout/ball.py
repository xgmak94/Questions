import pygame
import random
import constants

class Ball(pygame.sprite.Sprite):
    def __init__(self, color, rad):
        super().__init__()
        
        self.image = pygame.Surface([rad, rad])
        self.image.fill(constants.COLOR_BLACK)
        self.image.set_colorkey(constants.COLOR_BLACK)
 
        pygame.draw.rect(self.image, color, [0, 0, rad, rad])
        
        self.velocity = []
        self.velocity.append(random.randint(5, 10))
        self.velocity.append(random.randint(5, 10))

        self.rect = self.image.get_rect()
    
    def bounce(self):
        self.velocity[0] = self.velocity[0]
        self.velocity[1] = -self.velocity[1]

    def update(self):
        self.rect.x += self.velocity[0]
        self.rect.y += self.velocity[1]