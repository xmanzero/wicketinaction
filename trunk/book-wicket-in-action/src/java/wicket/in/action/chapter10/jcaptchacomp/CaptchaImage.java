package wicket.in.action.chapter10.jcaptchacomp;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.image.resource.DynamicImageResource;

import com.octo.captcha.service.image.ImageCaptchaService;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public abstract class CaptchaImage extends Image {

  public CaptchaImage (String id,
      final String challengeId) {

    super(id);
    setImageResource(new DynamicImageResource() {
      @Override
      protected byte[] getImageData() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        BufferedImage challenge = getImageCaptchaService()
            .getImageChallengeForID(challengeId,
                Session.get().getLocale());
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
        try {
          encoder.encode(challenge);
          return os.toByteArray();
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  protected abstract ImageCaptchaService getImageCaptchaService();
}
